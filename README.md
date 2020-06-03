# Description
The application sorts the names ignoring case and accent.
In console  will print sorted names with sequence.

# Specification
Create simple java program to quick sort names ignoring case and accent. The algorithm for sorting and ignoring case and accent is part of solution, do not use build in functions.

# Commands:

* Run as a Console application:         ```mvn clean package && java -jar ./target/sort-1.0.0-SNAPSHOT.jar "Erik" "blažej" "Zdenko" "Dezider" "Blazena" "Arpád" "zdenka"```
* Run as a docker container:            ```mvn clean install && docker-compose up```

Expected Sorted Result ```"Arpád" "blažej" "Blazena" "Dezider" "Erik" "zdenka" "Zdenko"```

# Stack
* Java 8
* Docker 19.03.8
* Docker Compose 3.7
* Maven 3.6.1
* Spring Boot 2.4.0-SNAPSHOT

# Run as a CMD application
From project folder execute ```./run.sh``` script

# Run as a docker container
From project folder execute ```./run-docker.sh``` script

# Run Tests
mvn clean test
 
# Additional Information 

*NOTE FOR WINDOWS USERS:*

Please make sure that have installed docker desktop on your local machine and in Settings -> General -> (expose demon on tcp://localhost:2375 without TLS) is enabled.
Set the environment variable COMPOSE_CONVERT_WINDOWS_PATHS=1
In Settings -> Shared Drives share at least your main System Drive.

# Short commands list for containers/images/volumes

List all containers (only IDs)
docker ps -aq

List all images
docker images ls

List all volumes
docker volume ls

Stop all running containers
docker stop $(docker ps -aq)

Remove all containers
docker rm $(docker ps -aq)

Remove all container(s) by id(s)
docker rm container_id1 container_id2

Remove all images
docker rmi $(docker images -q)

Removing All Unused Objects
docker system prune

Remove image(s) by id(s)
docker rmi image_id1 image_id2 - delete image(s)

Inspect the image
docker inspect image_id

Inspect the container
docker inspect container_id
