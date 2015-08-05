#!/bin/sh

set -e

APP="/home/registrolivre/app"
ROOT_PATH="./../../"

echo "=====> Generate jar"
${ROOT_PATH}gradlew :registroLivreJar

echo "=====> Stopping registrolivre service"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "service registrolivre stop"

echo "=====> Removing registrolivre jar"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "rm -rf ${APP}/registrolivre.jar"

echo "=====> Copy jar to app folder"
scp -i $REGISTROLIVRE_PRIVATE_KEY ${ROOT_PATH}registrolivre.jar registrolivre@$AWS_REGISTROLIVRE_IP:${APP}/registrolivre.jar

echo "=====> Starting registrolivre service"
ssh -i $REGISTROLIVRE_PRIVATE_KEY registrolivre@$AWS_REGISTROLIVRE_IP "service registrolivre start"