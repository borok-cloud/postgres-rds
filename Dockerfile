# Use office jdk17 image
FROM openjdk:17-jdk-alpine
# set the working directory in the container
WORKDIR /usr/app
#copy the compiled java jar file to the working directory into the container
COPY ./target/postgres-rds-0.0.1-SNAPSHOT.jar /usr/app/

#export the port the app runs in
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","postgres-rds-0.0.1-SNAPSHOT.jar"]