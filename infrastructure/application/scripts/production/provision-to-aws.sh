#!/bin/sh

set -e
SCRIPTS_PATH="/home/ubuntu/scripts"
PROVISION_PATH="/home/ubuntu/scripts/provision"
USER="/home/registrolivre"

echo "=====> Creating scripts folder"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo rm -rf ${SCRIPTS_PATH}"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo mkdir ${SCRIPTS_PATH}"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo chmod 777 ${SCRIPTS_PATH}"

echo "=====> Copying script files"
scp -i $AWS_APP_KEY -r ./scripts/provision/ ubuntu@$AWS_IP_OR_DNS:${SCRIPTS_PATH}
scp -i $AWS_APP_KEY -r ../scripts/provision/open-jdk8.sh ubuntu@$AWS_IP_OR_DNS:${PROVISION_PATH}

echo "=====> Creating public keys folder"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo rm -rf /home/public_keys"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo mkdir -p /home/public_keys"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo chmod 777 /home/public_keys"

echo "=====> Copying public keys folder"
scp -i $AWS_APP_KEY -r ./public_keys/* ubuntu@$AWS_IP_OR_DNS:/home/public_keys

echo "=====> Provisioning ..."
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/open-jdk8.sh"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/create-user.sh"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/ssh-user-permission.sh"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/create-folders.sh"
scp -i $AWS_APP_KEY ./scripts/provision/application-service.sh ubuntu@$AWS_IP_OR_DNS:${USER}/service
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/remove-application-service.sh"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo sh ${PROVISION_PATH}/create-application-service.sh"
echo "=====> End Provision ..."


echo "=====> Removing provision files"
ssh -i $AWS_APP_KEY ubuntu@$AWS_IP_OR_DNS "sudo rm -rf ${SCRIPTS_PATH}"