#!/bin/sh

sudo echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
sudo apt-get update
sudo apt-get --yes install go-server

#copy file that contains login informations of go users in hash64
cp /vagrant/configurations/htpasswd /etc/go

#copy cruise-config.xml that contains the pipeline of this project
/etc/init.d/go-server stop
cp /vagrant/configurations/cruise-config.xml /etc/go
/etc/init.d/go-server start
