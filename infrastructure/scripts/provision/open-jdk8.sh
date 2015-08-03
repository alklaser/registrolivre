#!/bin/sh

set -e

sudo su <<BLOCK
    echo "=====> Installing openjdk-8"
    dpkg --configure -a
    apt-get update
    apt-get --yes install software-properties-common  python-software-properties
    add-apt-repository --yes ppa:openjdk-r/ppa
    apt-get update
    apt-get --yes install openjdk-8-jdk
BLOCK

