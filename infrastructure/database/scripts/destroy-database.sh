#!/bin/sh

set -e

DATABASE="/home/registrolivre/database"

echo "=====> Destroying database"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$REGISTROLIVRE_IP_OR_DNS "sudo mkdir -p ${DATABASE}"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$REGISTROLIVRE_IP_OR_DNS "sudo chmod 777 ${DATABASE}"
scp -i $REGISTROLIVRE_PRIVATE_KEY ./scripts/postgres-uninstall.sh registrolivre@$REGISTROLIVRE_IP_OR_DNS:${DATABASE}
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$REGISTROLIVRE_IP_OR_DNS "bash -s < ${DATABASE}/postgres-uninstall.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$REGISTROLIVRE_IP_OR_DNS "sudo rm -rf ${DATABASE}"