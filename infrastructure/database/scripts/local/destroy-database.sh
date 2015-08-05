#!/bin/sh

set -e

DATABASE="/home/registrolivre/database"

echo "=====> Destroying database"
scp -i $REGISTROLIVRE_PRIVATE_KEY ./scripts/postgres-uninstall.sh registrolivre@$LOCAL_REGISTROLIVRE_IP:${DATABASE}
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$LOCAL_REGISTROLIVRE_IP "service registrolivre stop"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$LOCAL_REGISTROLIVRE_IP "bash -s < ${DATABASE}/postgres-uninstall.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$LOCAL_REGISTROLIVRE_IP "sudo rm -rf ${DATABASE}"