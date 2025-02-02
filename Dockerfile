# Dockerfile is a list to commands required to build the image
# Always start with a base image. Image name indicated by RepoName:TAG
# Ubuntu image taken from here: https://hub.docker.com/_/ubuntu
FROM ubuntu:25.04

# update will refresh the packages list in the ubuntu image
RUN apt update

# Install openjdk in the image. Generally apt install requires you to confirm using
# yes or no when installing. -y ensures that that confirmation is not asked.
RUN apt install -y openjdk-21-jdk

# Install maven in the image
RUN apt install -y maven

# This ensures all additional commands are executed in /app. This will set the current
# directory in the image to /app
WORKDIR /app

# Copy all the code in the current directory inside the image under app directory
# app is present under root folder indicated by "/". The first dot denotes current
# directory of the host system. the second one denotes current directory of the 
# image (/app set by WORKDIR)
COPY . .

# Build the image
RUN mvn install

# Entrypoint works only when we run the app. FOllowing command will not print
# anything when you build the app instead it should print java version when you
# run the container.
ENTRYPOINT [ "java", "-jar", "target/employeemanagement-0.1.jar" ]

# To build this image, run the following command:
# docker build . -t employeemanagementsystem:v0.1

# To run this image, run the following command:
# docker run -p 8080:8080 employeemanagementsystem:v0.1

# To check if service is correctly, run the curl command on the host machine's terminal:
# curl -H 'Content-Type: application/json' -d '{"empId":10, "deptId":10, "empName": "Gaggu","salary":100.00}' -X POST http://localhost:8080/employees