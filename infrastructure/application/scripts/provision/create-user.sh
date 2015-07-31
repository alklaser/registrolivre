#!/bin/sh

set -e
USER="registrolivre"

echo "=====> Creating registrolivre user"
if [ -z "$(getent passwd ${USER})" ]; then
    sudo useradd -d /home/${USER} -s /bin/bash -m ${USER}
    sed -i -e '/Defaults\s\+env_reset/a Defaults\texempt_group=admin' /etc/sudoers
    groupadd -r admin || true
    usermod -a -G admin ${USER}
    sed -i -e 's/%admin ALL=(ALL) ALL/%admin ALL=(ALL) NOPASSWD:ALL/g' /etc/sudoers
fi
