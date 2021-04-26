#!/usr/bin/bash

connections=125
number_of_requests=1000000

declare -a projects=(
    'java-springboot-jetty' 
    'java-springboot-tomcat' 
    'java-springboot-undertow' 
    'java-springboot-webflux-netty' 
    'javascript-express' 
    'javascript-http' 
    'javascript-restfy')

for container_name in ${projects[@]}; do

    printf "===================== ${container_name} ======================\n\n"

    printf "=== Pull and Run docker application ===\n\n"
    docker run -d --rm --net=host -p 8080:8080 --name ${container_name} --rm achimid/frameworks-performance-${container_name}:latest; sleep 10;

    printf "=== Running performance test ===\n\n"
    docker run --net=host -it alpine/bombardier -c ${connections} -n ${number_of_requests} -l localhost:8080/hello;

    printf "=== Stopping docker ===\n\n"
    docker stop ${container_name};

done