#!/bin/sh

#Use this command to access GO instance in aws
#ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP

echo "=====> Starting configuration Go Server on AWS machine"
PROVISION_PATH="./scripts/provision/."
CONFIGURATIONS_PATH="./configurations/."
SCRIPTS_PATH="/tmp/go"

echo "=====> Creating scripts folder"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sudo rm -rf ${SCRIPTS_PATH}"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sudo mkdir ${SCRIPTS_PATH}"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sudo chmod 777 ${SCRIPTS_PATH}"


echo "=====> Copying script files"
scp -i $GO_SERVER_REGISTROLIVRE_KEY -r ${PROVISION_PATH} ubuntu@$GO_SERVER_AWS_IP:${SCRIPTS_PATH}
scp -i $GO_SERVER_REGISTROLIVRE_KEY -r ${CONFIGURATIONS_PATH} ubuntu@$GO_SERVER_AWS_IP:${SCRIPTS_PATH}
scp -i $GO_SERVER_REGISTROLIVRE_KEY -r ./../scripts/provision/open-jdk8.sh ubuntu@$GO_SERVER_AWS_IP:${SCRIPTS_PATH}

echo "=====> Running provision scripts"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sh ${SCRIPTS_PATH}/open-jdk8.sh"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sh ${SCRIPTS_PATH}/export-java_home.sh"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sh ${SCRIPTS_PATH}/go-server.sh"


echo "=====> Removing provision files"
ssh -i $GO_SERVER_REGISTROLIVRE_KEY ubuntu@$GO_SERVER_AWS_IP "sudo rm -rf ${SCRIPTS_PATH}"




