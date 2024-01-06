FROM openjdk:17-jdk-slim
ADD ./target/blog.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar