FROM eclipse-temurin:17-jre-alpine
COPY /target/vocabulary.jar /vocabulary.jar
ENTRYPOINT ["java","-jar","/vocabulary.jar"]

