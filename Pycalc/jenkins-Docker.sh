#!/bin/bash
docker network create jenkins
docker build -t myjenkins-blueocean:2.319.3-1 .
./Docker_run.yml