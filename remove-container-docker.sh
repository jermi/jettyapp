#! /bin/bash

CONTAINER_NAME=jettyapp_container

# TODO to dziala tylko w przypadku jak bedzie tylko 1 kontener
if [ -n "$( docker ps -a | grep $CONTAINER_NAME )" ]
then
  echo "removing container $CONTAINER_NAME"
  docker rm -f $CONTAINER_NAME
fi


