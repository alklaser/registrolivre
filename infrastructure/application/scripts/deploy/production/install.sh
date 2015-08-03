#!/bin/sh

set -e

APP="/home/registrolivre/app"

echo "=====> Generate jar"
./../../gradlew :registroLivreJar

echo "=====> Stopping registrolivre service"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "service registrolivre stop"

echo "=====> Removing registrolivre jar"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "rm -rf ${APP}/registrolivre.jar"

echo "=====> Copy jar to app folder"
scp -i $REGISTROLIVRE_PRIVATE_KEY ~/Documents/registrolivre.jar registrolivre@$AWS_REGISTROLIVRE_IP:${APP}/

echo "=====> Starting registrolivre service"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "service registrolivre start"