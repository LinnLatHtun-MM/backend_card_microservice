#Strat with a base image containing Java Runtime
FROM openjdk:21-jdk-slim

MAINTAINER LINLAT HTUN

#Add the application's jar to the container
COPY target/Card-0.0.1-SNAPSHOT.jar Card-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java","-jar","Card-0.0.1-SNAPSHOT.jar"]

#--------------------Running Commands in Terminal ------------------

## 1 . Check Docker version - docker version

## 2. Generate a tag with date-time (e.g., 2025-04-07_1530)
#     TAG=$(date +%Y-%m-%d_%H%M)

## 3. Build the Docker image with the dynamic tag
#     docker build -t my-springboot-app:$TAG .

## 4. Build Command -
#  docker build . -t linnlathtun99/card:$(date +%Y-%m-%d_%H-%M) (tag)

## 5. show the images running docker
#     docker images

## 6. docker inspect image c6982a31f36b

## 7. docker run -p 8080:8080 linnlathtun99/card:2025-04-08_13-09

## 8. Detech mode means without prompting the logs and shows only container id
#     docker run -d -p 8080:8080 linnlathtun99/card:2025-04-08_13-09

## 9. running container
#     docker ps

## 10. To see all container
#      docker ps -a

## 11. Port mapping
#      docker run -p 9090:8080 my-springboot-app

## 12. Push image to the Docker Hub Repository
#      docker image push docker.io/linnlathtun99/card:2025-04-17_22-24