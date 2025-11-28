FROM openjdk:17.0.2
VOLUME /tmp
ADD target/campushub-gateway-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
