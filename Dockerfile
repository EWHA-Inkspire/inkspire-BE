# Dockerfile

# jdk17 Image Start
FROM openjdk:17

# 인자 설정 - JAR_File
ARG JAR_PATH=build/libs/*.jar

# JAR 파일 복제
COPY ${JAR_PATH} app.jar

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]