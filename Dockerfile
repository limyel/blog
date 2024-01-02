FROM openjdk:8-jdk-alpine
ADD ./target/blog.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar