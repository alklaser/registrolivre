#!/bin/sh

set -e

sudo su <<BLOCK
    echo "=====> Exporting JAVA_HOME"
    echo "export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64" >> /etc/environment
BLOCK