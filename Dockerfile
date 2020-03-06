FROM openjdk:8
EXPOSE 8080
COPY target/todo-service*.jar todo-service.jar
ENTRYPOINT [ "java", "-jar","todo-service.jar"]

