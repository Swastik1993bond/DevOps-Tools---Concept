#!/bin/bash
echo "............Creating New Docker network ......................"
docker network create jenkins
echo "............Building New Docker Image........................"
docker build -t myjenkins-blueocean:2.319.3-1 .
echo "............Running Docker conatiner with parameters.............................."
docker run \
  --name jenkins-blueocean \
  --rm \
  --detach \
  --network jenkins \
  --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client \
  --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 \
  --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  myjenkins-blueocean:2.319.3-1