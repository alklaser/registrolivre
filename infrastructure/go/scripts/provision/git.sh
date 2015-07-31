#!/bin/sh

set -e

sudo su <<BLOCK
    apt-get update
    apt-get --yes install git
BLOCK
