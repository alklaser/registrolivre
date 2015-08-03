#!/bin/sh

#Use this command to access GO instance in aws
#ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS

echo "=====> Starting configuration Go Agent on AWS machine"
SCRIPTS_PATH="/tmp/go"
PROVISION_PATH="./scripts/provision/."
CONFIGURATIONS_PATH="./configurations/."

echo "=====> Creating scripts folder"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sudo rm -rf ${SCRIPTS_PATH}"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sudo mkdir ${SCRIPTS_PATH}"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sudo chmod 777 ${SCRIPTS_PATH}"


echo "=====> Copying script files"
scp -i $AWS_GO_AGENT_KEY -r ${PROVISION_PATH} ubuntu@$AWS_GO_AGENT_DNS:${SCRIPTS_PATH}
scp -i $AWS_GO_AGENT_KEY -r ${CONFIGURATIONS_PATH} ubuntu@$AWS_GO_AGENT_DNS:${SCRIPTS_PATH}
scp -i $AWS_GO_AGENT_KEY -r ./../scripts/provision/open-jdk8.sh ubuntu@$AWS_GO_AGENT_DNS:${SCRIPTS_PATH}

echo "=====> Running provision scripts"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/open-jdk8.sh"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/export-java_home.sh"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/git.sh"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/nodejs.sh"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/go-agent.sh"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sh ${SCRIPTS_PATH}/export-go_server.sh $AWS_GO_SERVER_DNS"


echo "=====> Removing provision files"
ssh -i $AWS_GO_AGENT_KEY ubuntu@$AWS_GO_AGENT_DNS "sudo rm -rf ${SCRIPTS_PATH}"




