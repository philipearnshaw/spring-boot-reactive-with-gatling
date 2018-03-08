# spring-boot-reactive-with-gatling

docker kill $(docker ps -q)
docker rm $(docker ps -a -q)
docker run -p 27017:27017 -d mongo


mvn -Dgatling.simulation.name=CustomerSimulation gatling:execute