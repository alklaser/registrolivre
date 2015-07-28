#!/bin/sh

sudo echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
apt-get update
apt-get --yes install go-agent
sudo /etc/init.d/go-agent start
