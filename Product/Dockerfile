FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/rahulNineleaps/NineleapsPoc.git
RUN ls > tempfile
RUN cat tempfile
RUN pwd
FROM maven:3.5-jdk-8-alpine as build
COPY --from=clone /app/NineleapsPoc /app
WORKDIR /app/Product
RUN ls

RUN mvn clean install -DskipTests
FROM openjdk:8-jdk-alpine
COPY --from=build /app/taget/productservice*.jar /tmp/productservice.jar
COPY docker-resources /tmp
ENV JAVA_OPTS=""
RUN apk update && apk add netcat-openbsd
EXPOSE 1971
ENTRYPOINT ["/tmp/docker-entrypoint.sh"]

