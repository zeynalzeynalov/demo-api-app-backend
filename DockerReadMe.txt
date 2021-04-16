//building docker image
docker build . -t taxdooapiwithjava

//running docker image
docker run -p 8090:8090 taxdooapiwithjava
