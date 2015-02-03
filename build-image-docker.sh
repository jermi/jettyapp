./remove-container-docker.sh

if [ -n "$( docker images | grep "jettyapp *dev" )"  ]
then
  echo "removing image jettyapp:dev"
  docker rmi -f jettyapp:dev
fi

echo "building image jettyapp:dev"
docker build -t jettyapp:dev --rm .
