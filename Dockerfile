FROM openjdk:17-jdk-alpine3.14
ADD ./target/blog.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar