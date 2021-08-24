#!/bin/bash

cd artist-service && mvn package && cd .. && \
cd music-service && mvn package && cd .. && \
cd naming-server && mvn package && cd .. && \
cd payment-api-service && mvn package && cd .. && \
cd playlist-service && mvn package && cd .. && \
cd user-service && mvn package && cd .. && \
docker-compose up -d --build
