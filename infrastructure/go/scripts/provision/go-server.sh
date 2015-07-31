#!/bin/sh

set -e

sudo su <<BLOCK
    echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
    wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
    apt-get --yes purge go-server
    apt-get update
    apt-get --yes install go-server

    #copying configuration files

    /etc/init.d/go-server stop
    cp /tmp/cruise-config.xml /etc/go
    cp /tmp/htpasswd /etc/go
    /etc/init.d/go-server start
BLOCK
