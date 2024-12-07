import os
import requests
import subprocess
import time
import shutil

API_URL = "https://api.chatanywhere.tech/v1/chat/completions"
API_KEY = "<your apikey>"
HEADERS = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json"
}
MAX_RETRIES = 3
MAIN_DIR = "src/main/java/net/mooctest"
TEST_DIR = "src/test/java/net/mooctest"
SAMPLE_TEST_FILE = "*Test.java"
PROCESS_LOG = "process.txt"
MAX_TOKENS = 3000

def log_to_file(message):
    with open(PROCESS_LOG, "a") as f:
        f.write(message + "\n")

def send_to_gpt(messages):
    data = {
        "model": "gpt-3.5-turbo",
        "messages": messages,
        "max_tokens": MAX_TOKENS
    }

    log_to_file("User: " + messages[-1]['content'])

    response = requests.post(API_URL, headers=HEADERS, json=data)
    if response.status_code != 200:
        error_message = f"Error: API request failed with status code {response.status_code}\nResponse: {response.text}"
        log_to_file(error_message)
        print(error_message)
        return None

    response_json = response.json()
    log_to_file("GPT: " + response_json['choices'][0]['message']['content'])

    if 'choices' not in response_json:
        error_message = f"Error: 'choices' not found in response JSON\nResponse JSON: {response_json}"
        log_to_file(error_message)
        print(error_message)
        return None

    # 提取返回的测试用例代码部分
    gpt_message = response_json['choices'][0]['message']['content']
    test_code = gpt_message.split("```java")[1].split("```")[0].strip() if "```java" in gpt_message else gpt_message
    return test_code

def run_custom_test():
    result = subprocess.run(["./run.sh"], capture_output=True, text=True)
    with open("test.txt", "w") as f:
        f.write(result.stdout)
        f.write(result.stderr)
    return result.returncode, result.stdout + result.stderr

def extract_error_message(output):
    error_start = output.find("ERROR")
    if error_start != -1:
        return output[error_start:]
    return None

def check_test_success():
    with open("test.txt", "r") as f:
        content = f.read()
    return "BUILD SUCCESS" in content

def main():
    # 清空 TEST_DIR 文件夹
    if os.path.exists(TEST_DIR):
        shutil.rmtree(TEST_DIR)
    os.makedirs(TEST_DIR)

    java_files = [f for f in os.listdir(MAIN_DIR) if f.endswith(".java")]
    for java_file in java_files:
        file_path = os.path.join(MAIN_DIR, java_file)
        with open(file_path, "r") as f:
            file_content = f.read()

        # 第一次发送示例代码
        messages = [
            {"role": "system", "content": "你是一个经验丰富的软件开发者测试人员。"},
            {"role": "user", "content": f"请按照编写基于junit4框架的断言测试,尽量保证高覆盖率：{SAMPLE_TEST_FILE}。以下是代码：\n{file_content}"}
        ]

        retries = 0
        while retries < MAX_RETRIES:
            test_content = send_to_gpt(messages)
            if test_content is None:
                print(f"Skipping {java_file} due to API request failure.")
                break

            test_file_path = os.path.join(TEST_DIR, java_file.replace(".java", "Test.java"))
            with open(test_file_path, "w") as f:
                f.write(test_content)

            returncode, output = run_custom_test()
            if returncode == 0 and check_test_success():
                print(f"Tests for {java_file} passed.")
                break
            else:
                print(f"Tests for {java_file} failed. Retrying...")
                error_message = extract_error_message(output)
                if error_message:
                    messages = [
                        {"role": "system", "content": "你是一个经验丰富的软件开发者测试人员。"},
                        {"role": "user", "content": f"请按照这种格式编写基于junit4框架的断言测试：{SAMPLE_TEST_FILE}。以下是代码：\n{file_content}"},
                        {"role": "user", "content": f"测试运行失败，错误信息如下：\n{error_message}\n请修改测试用例。"}
                    ]
                    test_content = send_to_gpt(messages)
                retries += 1

        if retries == MAX_RETRIES:
            print(f"Failed to generate passing tests for {java_file} after {MAX_RETRIES} retries. Skipping...")
            os.remove(test_file_path)

if __name__ == "__main__":
    main()