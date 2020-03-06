FROM openjdk:8
EXPOSE 8080
COPY target/todo-service*.jar /opt/ctl/todo-service/todo-service.jar
CMD [ "java", "-jar","todo-service.jar"]

