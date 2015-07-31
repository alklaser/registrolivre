#!/bin/sh

set -e

sudo su <<BLOCK
    apt-get install --yes build-essential
    apt-get update
    apt-get --yes install curl
    curl -sL https://deb.nodesource.com/setup | sudo bash -
    apt-get install -y nodejs
    npm install npm -g
BLOCK