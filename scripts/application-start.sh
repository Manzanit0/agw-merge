#!/usr/bin/env bash

# Compile the application.
cd /var/http-server/
mvn package

systemctl start http-server.service