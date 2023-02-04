FROM openjdk:17-jdk-slim-buster
WORKDIR /app
#VOLUME /temp
COPY target/walgreenspharmacy-3.0.1.jar build/
WORKDIR /app/build
ENTRYPOINT java -jar walgreenspharmacy-3.0.1.jar
Expose 8081