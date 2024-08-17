FROM openjdk:21
COPY target/spring-boot-docker.jar spring-boot-docker.jar
ENV spring.datasource.username=postgres
ENV spring.datasource.password=123
ENV spring.datasource.url=jdbc:postgresql://localhost:1245/postgres
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
