FROM openjdk:25-slim-bullseye

# Adding the Jar file to the container
ADD target/roomza-connect-za.jar /roomza-connect-za.jar

# Setting the entrypoint for running the app
ENTRYPOINT ["java", "-jar", "/roomza-connect-za.jar"]
