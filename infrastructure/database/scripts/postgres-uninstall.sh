#!/bin/sh

set -e

if [ ! -z "$(sudo -u postgres psql -c "SELECT datname FROM pg_database WHERE datname = 'registro_livre';" | grep 'registro_livre')" ]; then
      sudo -u postgres psql -c "DROP DATABASE registro_livre;"
      sudo -u postgres psql -c "DROP ROLE registro_livre_user;"
  fi

  if [ ! -z "$(which postgres)" ] || [ "$(which postgres)" != 'postgres not found' ]; then
      sudo apt-get --purge remove postgresql-9.4 --yes
  fi