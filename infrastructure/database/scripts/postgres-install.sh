#!/bin/sh

set -e

if [ -z "$(which postgres)" ] || [ "$(which postgres)" == 'postgres not found' ]; then
    sudo apt-get install postgresql-9.1 --yes
fi

if [ -z "$(sudo -u postgres psql -c "SELECT datname FROM pg_database WHERE datname = 'registro_livre';" | grep 'registro_livre')" ]; then
    sudo -u postgres psql -c "CREATE ROLE registro_livre_user WITH ENCRYPTED PASSWORD 'registro_livre_user' LOGIN;"
    sudo -u postgres psql -c "CREATE DATABASE registro_livre WITH OWNER = registro_livre_user;"
fi