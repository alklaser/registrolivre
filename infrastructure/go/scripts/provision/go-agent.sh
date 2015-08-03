#!/bin/sh

set -e

echo $1

sudo su <<BLOCK
    #echo "deb http://dl.bintray.com/gocd/gocd-deb/ /" > /etc/apt/sources.list.d/gocd.list
    #wget --quiet -O - "https://bintray.com/user/downloadSubjectPublicKey?username=gocd" | sudo apt-key add -
    #apt-get update
    #apt-get --yes purge go-agent
    #apt-get --yes install go-agent
    #perl -pi -e 's/abc/XYZ/g' /tmp/file.txt

BLOCK