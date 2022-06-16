#define base docker image
FROM openjdk:11
lABEL maintainer="amina"
Add target/contact-0.0.1-SNAPSHOT.jar contact.jar
ENTRYPOINT ("java", "jar", "contact.jar")
