#!/bin/sh

set -e
SCRIPTS="/home/ubuntu/scripts"
PROVISION="/home/ubuntu/scripts/provision"
PUBLIC_KEYS="/home/public_keys"
USER="/home/registrolivre"

echo "=====> Creating scripts folder"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo mkdir ${SCRIPTS}"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo chmod 777 ${SCRIPTS}"

echo "=====> Copying script files"
scp -i $AWS_PRIVATE_KEY -r ./scripts/provision/ ubuntu@$AWS_IP_OR_DNS:${SCRIPTS}
scp -i $AWS_PRIVATE_KEY -r ../scripts/provision/open-jdk8.sh ubuntu@$AWS_IP_OR_DNS:${PROVISION}

echo "=====> Creating public keys folder"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo mkdir -p ${PUBLIC_KEYS}"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo chmod 777 ${PUBLIC_KEYS}"

echo "=====> Copying public keys folder"
scp -i $AWS_PRIVATE_KEY -r ./public_keys/* ubuntu@$AWS_IP_OR_DNS:/home/public_keys

echo "=====> Provisioning ..."
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/open-jdk8.sh"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/create-user.sh"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/ssh-user-permission.sh"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/create-folders.sh"
scp -i $AWS_PRIVATE_KEY ./scripts/provision/application-service.sh ubuntu@$AWS_IP_OR_DNS:${USER}/service
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/remove-application-service.sh"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION}/create-application-service.sh"
echo "=====> End Provision ..."


echo "=====> Removing provision files"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo rm -rf ${SCRIPTS}"
ssh -i $AWS_PRIVATE_KEY ubuntu@$AWS_IP_OR_DNS "sudo rm -rf ${PUBLIC_KEYS}"