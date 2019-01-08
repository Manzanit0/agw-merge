#!/usr/bin/env bash

# Compile the application.
cd /var/http-server/
mvn package

cd target/ # Directory which contains compiled JAR.
java -jar http-server-1.0.jar > /dev/null 2>&1 &