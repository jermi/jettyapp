#! /bin/bash
CONTAINER_NAME=jettyapp_container

if [ -n "$( docker ps -a | grep $CONTAINER_NAME )" ]
then
  echo "removing container $CONTAINER_NAME"
  docker rm -f $CONTAINER_NAME
fi


