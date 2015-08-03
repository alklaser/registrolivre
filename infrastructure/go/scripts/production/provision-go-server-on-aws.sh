#!/bin/sh

#Use this command to access GO instance in aws
#ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS

SCRIPTS_PATH="/tmp/go"

echo "=====> Creating scripts folder"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sudo rm -rf ${SCRIPTS_PATH}"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sudo mkdir ${SCRIPTS_PATH}"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sudo chmod 777 ${SCRIPTS_PATH}"


echo "=====> Copying script files"
scp -i $AWS_GO_SERVER_KEY -r ../provision/. ubuntu@$AWS_GO_SERVER_DNS:${SCRIPTS_PATH}
scp -i $AWS_GO_SERVER_KEY -r ../../configurations/. ubuntu@$AWS_GO_SERVER_DNS:${SCRIPTS_PATH}
scp -i $AWS_GO_SERVER_KEY -r ../../../scripts/provision/open-jdk8.sh ubuntu@$AWS_GO_SERVER_DNS:${SCRIPTS_PATH}

echo "=====> Running provision scripts"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sh ${SCRIPTS_PATH}/open-jdk8.sh"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sh ${SCRIPTS_PATH}/export-java_home.sh"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sh ${SCRIPTS_PATH}/go-server.sh"


echo "=====> Removing provision files"
ssh -i $AWS_GO_SERVER_KEY ubuntu@$AWS_GO_SERVER_DNS "sudo rm -rf ${SCRIPTS_PATH}"




