FROM openjdk:8
ADD target/stockmarket-0.0.1-SNAPSHOT.jar stockmarket.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","stockmarket.jar"]