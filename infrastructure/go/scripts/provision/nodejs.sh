#!/bin/sh

sudo apt-get update
sudo apt-get --yes install curl
curl -sL https://deb.nodesource.com/setup | sudo bash -
sudo apt-get install -y nodejs
sudo npm install npm -g
