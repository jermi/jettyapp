#! /bin/bash
CONTAINER_NAME=jettyapp_container
IMAGE_NAME=jettyapp

if [ -n 'docker ps | grep $CONTAINER_NAME' ]
then
  echo "stopping and removing container $CONTAINER_NAME"
  docker stop $CONTAINER_NAME
  docker rm $CONTAINER_NAME	
fi

docker run -itd -p 8000:8080 --name="$CONTAINER_NAME" $IMAGE_NAME
