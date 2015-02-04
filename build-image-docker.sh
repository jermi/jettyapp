#! /bin/bash

sh ./remove-container-docker.sh

IMAGE_NAME="jenker:5000/jettyapp:dev"

# TODO: to dziala tylko w przypadku jak bedzie tylko 1 obraz
if [ -n "$( docker images | grep "jettyapp *dev" )"  ]
then
  echo "removing image $IMAGE_NAME"
  docker rmi -f $IMAGE_NAME
fi

echo "building image $IMAGE_NAME"
docker build -t $IMAGE_NAME --rm .
