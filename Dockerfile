


FROM openjdk:21
COPY target/spring-boot-docker.jar spring-boot-docker.jar
ENV spring.datasource.username=postgres
ENV spring.datasource.password=123
ENV spring.datasource.url=jdbc:postgresql://178.128.217.132:6005/postgres
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
