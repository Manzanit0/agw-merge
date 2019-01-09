#!/usr/bin/env bash

yum install lsof
kill $(lsof -t -i:5000) || echo "The application isn't running"
