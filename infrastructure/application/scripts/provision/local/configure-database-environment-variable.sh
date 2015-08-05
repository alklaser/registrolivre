#!/bin/bash

set -e

USER="/home/registrolivre"

echo "=====> Configuring enviroment variables"
if [ -z "$(cat ${USER}/.profile | grep REGISTROLIVRE_DATABASE_URL)" ]; then
    echo 'export REGISTROLIVRE_DATABASE_URL="postgres://registro_livre_user:registro_livre_user@localhost:5432/registro_livre"' | tee -a ${USER}/.profile
    source ${USER}/.profile
fi
