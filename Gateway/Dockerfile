From openjdk:8
copy ./target/apigateway.jar apigateway.jar
ENV JAVA_OPTS=""
CMD ["java","-jar","${JAVA_OPTS}","apigateway.jar"]
EXPOSE 8765
