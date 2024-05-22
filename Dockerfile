FROM openjdk:21
ARG JAR_FILE=target/tasks-backend.JAR_FILE
ADD ${JAR-FILE} app.JARENTRYPOINT ["java","-jar","/app.jar"]