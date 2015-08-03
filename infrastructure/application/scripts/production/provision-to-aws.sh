#!/bin/sh

set -e
SCRIPTS="/home/ubuntu/scripts"
PROVISION="/home/ubuntu/scripts/provision"
PUBLIC_KEYS="/home/public_keys"
USER="/home/registrolivre"

echo "=====> Creating scripts folder"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo mkdir ${SCRIPTS}"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo chmod 777 ${SCRIPTS}"

echo "=====> Copying script files"
scp -i $REGISTROLIVRE_PRIVATE_KEY -r ./scripts/provision/ ubuntu@$AWS_REGISTROLIVRE_IP:${SCRIPTS}
scp -i $REGISTROLIVRE_PRIVATE_KEY -r ../scripts/provision/open-jdk8.sh ubuntu@$AWS_REGISTROLIVRE_IP:${PROVISION}

echo "=====> Creating public keys folder"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo mkdir -p ${PUBLIC_KEYS}"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo chmod 777 ${PUBLIC_KEYS}"

echo "=====> Copying public keys folder"
scp -i $REGISTROLIVRE_PRIVATE_KEY -r ./public_keys/* ubuntu@$AWS_REGISTROLIVRE_IP:/home/public_keys

echo "=====> Provisioning ..."
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/open-jdk8.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/create-user.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/ssh-user-permission.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/create-folders.sh"
scp -i $REGISTROLIVRE_PRIVATE_KEY ./scripts/provision/application-service.sh ubuntu@$AWS_REGISTROLIVRE_IP:${USER}/service
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/remove-application-service.sh"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo sh ${PROVISION}/create-application-service.sh"
echo "=====> End Provision ..."


echo "=====> Removing provision files"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo rm -rf ${SCRIPTS}"
ssh -i $REGISTROLIVRE_PRIVATE_KEY ubuntu@$AWS_REGISTROLIVRE_IP "sudo rm -rf ${PUBLIC_KEYS}"