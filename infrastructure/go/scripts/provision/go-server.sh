#!/bin/sh

sudo echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
sudo apt-get update
sudo apt-get --yes install go-server

/etc/init.d/go-server stop
cp /vagrant/configurations/cruise-config.xml /etc/go
/etc/init.d/go-server start
