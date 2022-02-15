#!/bin/bash
docker build -t bootdocker:1
docker run -d --name bootdocker -p 8080:8080 bootdocker:1