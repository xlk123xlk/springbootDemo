FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD eureka-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]