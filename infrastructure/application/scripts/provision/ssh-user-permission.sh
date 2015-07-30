#!/bin/sh

set -e
USER="registrolivre"
DIRECTORY="/home/registrolivre"

echo "=====> Creating .ssh folder"
sudo rm -rf ${DIRECTORY}/.ssh
sudo mkdir -p ${DIRECTORY}/.ssh

echo "=====> Creating authorized_keys file"
sudo touch ${DIRECTORY}/.ssh/authorized_keys

echo "=====> Moving public key to authorized keys"
for key in /home/public_keys/*; do
    cat $key | tee -a ${DIRECTORY}/.ssh/authorized_keys
done