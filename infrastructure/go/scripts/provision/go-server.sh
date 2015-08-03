#!/bin/sh

set -e

sudo su <<BLOCK
    echo "=====> Installing Go Server"
    echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
    wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
    apt-get --yes purge go-server
    apt-get update
    apt-get --yes install go-server

    echo "=====> Copying preset settings files for GO Server"
    /etc/init.d/go-server stop
    cp /tmp/go/cruise-config.xml /etc/go
    cp /tmp/go/htpasswd /etc/go
    /etc/init.d/go-server start
BLOCK
