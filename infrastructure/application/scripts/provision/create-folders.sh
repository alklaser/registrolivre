#!/bin/sh

set -e

DIRECTORY="/home/registrolivre"

echo "=====> Creating service folder"
sudo rm -rf ${DIRECTORY}/service
sudo mkdir ${DIRECTORY}/service
sudo chmod 777 ${DIRECTORY}/service

echo "=====> Creating app folder"
sudo rm -rf ${DIRECTORY}/app
sudo mkdir ${DIRECTORY}/app
sudo chmod 777 ${DIRECTORY}/app