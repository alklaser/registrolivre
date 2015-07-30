#!/bin/sh

set -e

ssh -i $AWS_KEY ubuntu@54.232.246.149 "rm -rf scripts"
ssh -i $AWS_KEY ubuntu@54.232.246.149 "mkdir scripts"