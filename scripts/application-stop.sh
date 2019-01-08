#!/usr/bin/env bash

sudo kill $(ps -ef | grep http-server-1.0 | awk '{print $2}')
