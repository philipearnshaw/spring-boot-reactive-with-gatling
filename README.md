# spring-boot-reactive-with-gatling

docker kill $(docker ps -q)
docker rm $(docker ps -a -q)

docker run -p 27017:27017 -d mongo


mvn -Dgatling.simulation.name=CustomerBlockingSimulation gatling:execute
mvn -Dgatling.simulation.name=CustomerReactiveSimulation gatling:execute

curl -H "Accept: application/json" "http://localhost:8080/blocking/customers"
curl -H "Accept: text/event-stream" "http://localhost:8080/customers"


ab -n500 -c1 -H 'Accept:application/json' http://localhost:8080/blocking/customers
ab -n500 -c1 -H 'text/event-stream' http://localhost:8080/customers

        





