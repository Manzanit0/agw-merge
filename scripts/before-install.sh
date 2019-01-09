#!/usr/bin/env bash

apt-get update

# Install Java JDK 11 - APT only has version 10.
wget https://download.java.net/java/GA/jdk11/28/GPL/openjdk-11+28_linux-x64_bin.tar.gz -O /tmp/openjdk-11+28_linux-x64_bin.tar.gz
tar xfvz /tmp/openjdk-11+28_linux-x64_bin.tar.gz --directory /usr/lib/jvm
rm -f /tmp/openjdk-11+28_linux-x64_bin.tar.gz

sh -c 'for bin in /usr/lib/jvm/jdk-11/bin/*; do update-alternatives --install /usr/bin/$(basename $bin) $(basename $bin) $bin 100; done'
sh -c 'for bin in /usr/lib/jvm/jdk-11/bin/*; do update-alternatives --set $(basename $bin) $bin; done'

# Install Apache Maven
apt install maven

# Setup the systemd service
sh -c "cat > http-server.service << EOF
[Unit]
Description=HTTP Server
[Service]
ExecStart=/var/http-server/scripts/run.sh
Type=simple
User=ubuntu
[Install]
WantedBy=multi-user.target
EOF"

mv http-server.service /etc/systemd/system

systemctl daemon-reload