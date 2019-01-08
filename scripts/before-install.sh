#!/usr/bin/env bash

yum upgrade
yum install wget

# Install Java JDK 11
curl -O https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz
tar zxvf openjdk-11.0.1_linux-x64_bin.tar.gz
mv jdk-11.0.1 /usr/local/

cat > /etc/profile.d/jdk11.sh << EOF
export JAVA_HOME=/usr/local/jdk-11.0.1
export PATH=$PATH:$JAVA_HOME/bin
EOF

source /etc/profile.d/jdk11.sh

# Install Apache Maven
wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
yum install -y apache-maven