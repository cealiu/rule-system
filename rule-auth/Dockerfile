FROM buildo/java8-wkhtmltopdf
VOLUME /tmp
ADD target/rule-auth-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

