我设置开始从src/main/java/net/mooctest挑一个发给gpt，让他回复测试代码，然后将测试代码加到src/test/java/net/mooctest文件夹测试，成功就进行下一个源代码，失败就把error部分内容发给gpt让他修改，如果失败三次就跳过这个源代码，进入下一个源代码的测试。
process.txt是存储程序跟gpt交互的过程，即给gpt发送了什么，gpt回复了什么
test.txt就是每次运行maven测试时的终端显示信息
我设置开始从src/main/java/net/mooctest挑一个发给gpt，让他回复测试代码，然后将测试代码加到src/test/java/net/mooctest文件夹测试，成功就进行下一个源代码，失败就把error部分内容发给gpt让他修改，如果失败三次就跳过这个源代码，进入下一个源代码的测试。
process.txt是存储程序跟gpt交互的过程，即给gpt发送了什么，gpt回复了什么
test.txt就是每次运行maven测试时的终端显示信息
https://api.chatanywhere.tech/v1/chat/completions
如果你没有apikey访问上面的链接，获取后到usegpt.py里面替换成你的apikey即可


curl https://api.chatanywhere.tech/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <your apikey>" \
  -d '{
    "model": "gpt-3.5-turbo",
    "messages": [
      {"role": "system", "content": "You are a helpful assistant."},
      {"role": "user", "content": "你是谁，给我介绍下宇宙几大星系"}
    ],
    "max_tokens": 1000
  }'
测试普通gpt的连通性