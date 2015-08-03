#!/bin/sh

set -e

sudo su <<BLOCK
    echo "=====> Exporting GO SERVER DNS "
    echo "export GO_SERVER=$1" >> /etc/environment
    /etc/init.d/go-agent start
BLOCK