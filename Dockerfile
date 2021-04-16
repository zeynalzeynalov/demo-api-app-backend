FROM adoptopenjdk/openjdk11:latest

LABEL base.name="taxdooapiwithjava"

EXPOSE 8090

ARG JAR_FILE=target/TaxdooAPI-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
