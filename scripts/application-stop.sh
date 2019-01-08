#!/usr/bin/env bash

yum install lsof
kill $(lsof -t -i:5000)
