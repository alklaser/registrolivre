#!/bin/sh

#Use this command to access GO instance in aws
#ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS

echo "=====> Coping scrips to AWS GO-CD instance"
sh copy-files.sh

echo "=====> Running provision scripts"
ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS "sh /home/$AWS_USER/provision/open-jdk8.sh"
ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS "sh /home/$AWS_USER/provision/export_java_home.sh"
ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS "sh /home/$AWS_USER/provision/git.sh"
ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS "sh /home/$AWS_USER/provision/go-server.sh"
ssh -i $AWS_GO_KEY $AWS_USER@$AWS_GO_IP_OR_DNS "sh /home/$AWS_USER/provision/go-agent.sh"
