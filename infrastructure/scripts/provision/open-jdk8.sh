#!/bin/sh

set -e

echo "=====> Installing openjdk-8"
sudo su <<BLOCK
    apt-get update
    apt-get --yes install software-properties-common  python-software-properties
    add-apt-repository --yes ppa:openjdk-r/ppa
    apt-get update
    apt-get --yes install openjdk-8-jdk
BLOCK

