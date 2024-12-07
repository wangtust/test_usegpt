#!/bin/bash

# 获取当前时间戳
TIMESTAMP=$(date +%Y%m%d%H%M%S)
REPORT_DIR="reports/$TIMESTAMP"

# 运行测试并生成覆盖率报告
echo "Running Maven tests"
mvn clean test
if [ $? -ne 0 ]; then
  echo "Maven test failed"
  exit 1
fi

# 等待测试完成
wait

# 创建一个目录来保存当前测试类的覆盖率报告和变异测试报告
echo "Creating directory $REPORT_DIR"
mkdir -p $REPORT_DIR/jacoco
mkdir -p $REPORT_DIR/pitest
mkdir -p $REPORT_DIR/test-code

# 复制生成的覆盖率报告到指定目录
if [ -d "target/site/jacoco" ]; then
  echo "Copying Jacoco report to $REPORT_DIR/jacoco"
  cp -r target/site/jacoco/* $REPORT_DIR/jacoco
else
  echo "Jacoco report not found"
  exit 1
fi

# 运行变异测试并生成报告
echo "Running PIT mutation tests"
mvn org.pitest:pitest-maven:mutationCoverage
if [ $? -ne 0 ]; then
  echo "PIT mutation test failed"
  exit 1
fi

# 复制生成的变异测试报告到指定目录
if [ -d "target/pit-reports" ]; then
  echo "Copying PIT report to $REPORT_DIR/pitest"
  cp -r target/pit-reports/* $REPORT_DIR/pitest
else
  echo "PIT report not found"
  exit 1
fi

# 复制测试代码到指定目录
if [ -d "src/test/java/net/mooctest" ]; then
  echo "Copying test code to $REPORT_DIR/test-code"
  cp -r src/test/java/net/mooctest/* $REPORT_DIR/test-code
else
  echo "Test code directory not found"
  exit 1
fi

echo "Coverage, mutation reports, and test code saved to $REPORT_DIR"