#! /bin/bash
CONTAINER_NAME=jettyapp_container
IMAGE_NAME=jettyapp:dev

./remove-container-docker.sh

#if [ -n "$( docker ps -a | grep $CONTAINER_NAME )" ]
#then
#  echo "removing container $CONTAINER_NAME"
#  docker rm -f $CONTAINER_NAME	
#fi

echo "running container $CONTAINER_NAME from image $IMAGE_NAME"
docker run -itd -p 8000:8080 --name="$CONTAINER_NAME" $IMAGE_NAME
