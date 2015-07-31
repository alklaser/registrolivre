#!/bin/sh


scp  -i $AWS_GO_KEY -r ../../provision/ $AWS_USER@$AWS_GO_IP_OR_DNS:/home/$AWS_USER
scp  -i $AWS_GO_KEY ../../../../scripts/provision/open-jdk8.sh $AWS_USER@$AWS_GO_IP_OR_DNS:/home/$AWS_USER/provision

scp  -i $AWS_GO_KEY ../../../configurations/cruise-config.xml $AWS_USER@$AWS_GO_IP_OR_DNS:/tmp/
scp  -i $AWS_GO_KEY ../../../configurations/htpasswd $AWS_USER@$AWS_GO_IP_OR_DNS:/tmp/


