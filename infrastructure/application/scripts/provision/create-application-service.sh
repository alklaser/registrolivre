#!/bin/sh

set -e

DIRECTORY="/home/registrolivre"

echo "=====> Creating registrolivre service"
sudo mv ${DIRECTORY}/service/application-service.sh /etc/init.d/registrolivre
sudo chmod +x /etc/init.d/registrolivre
sudo update-rc.d registrolivre defaults