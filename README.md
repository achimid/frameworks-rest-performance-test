# Comparação performática entre diferêntes frameworks e linkguagens

## Motivação
Após ler essa página/artigo "[Benchmarking Node.js Http Performance Part 1 Express.js](https://mamaz.github.io/benchmarking-nodejs-http-performance.html)" eu fiquei curioso em replicar estes testes com as linguagens de programação que eu estou utilizando recentemente. E pessoalmentea acredito que a melhor maneira de aprender é fazendo.

## Objetivo/Descrição
Tenho como objetivo o aprendizado de utilização da ferramenta de benchmark [Bombardier](https://github.com/codesenberg/bombardier) e a comparação entre as linguagens e os frameworks que eu utilizei recentemente. Para fins de aprendizado acredito que a execução destes testes possui a credibilidade necessário.

Para a realização dos teste, eu criei 4 aplicações em diferentes linguagens e frameworks que realizam a mesma ação. A aplicação é responsavel por receber uma requisição HTTP seguindo o protocolo REST e dar como resposta um texto estático escrito "hello".

Linguagens e Frameworks utilizados:

* Java + Spring Boot + Embed Tomcat
* Java + Spring Boot + Embed Jetty
* Java + Spring Boot + Embed Undertow
* Java + Spring Boot + WebFlux + Netty
* Java + Quarkus + Native
* Java + Http
* Javascript (NodeJS) + Express
* Javascript (NodeJS) + Restify
* Javascript (NodeJS) + Http
* Go + Http
* Python + Flask + Gunicorn


## Executando com Docker + Script
    wget https://raw.githubusercontent.com/achimid/frameworks-rest-performance-test/master/performance-test-script.sh
    bash ./performance-test-script.sh 


## Ferramenta de benchmark (Bombardier)
Seguindo a recomendação do artigo mencionado, utilizei como ferramenta de benchmark o (Bombardier), é uma ferramenta escrita em GO que fica responsavel por enviar as requisições de teste para as aplicações que será testada, com ela é possivel simular grandes quantidades de requisições paralelas. Ao final da execução é exibido um relatório informando os dados coletados.

No meu caso eu utilizei como quesito de comparação a média de requisições por segundos (Avg - Reqs/Sec).

Para efeutar a instalação da ferramenta eu segui este [link](https://softwaretester.info/http-benchmarking-with-bombardier/)

No artigo mencionado anteriormente e tambem nos meus testes, a ferramente foi configurada para efetuar um total de 5.000.000 (5 Milhões) de requisições, com 125 requisições em paralelo.


## Expecificações da maquina de teste

Segue abaixo as expecificações da maquina que eu executei os testes.

![machine-specs](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/machine-specs.png)

Deve ser resaltado que as aplicações não foram executadas simultaneamente, apenas uma aplicação foi executada por vez.

Deve ser resaltado que a aplicação e a ferramenta de banchmark foram executadas simultaneamente.

Deve ser resaltado que tentei manter as mesmas condições de execução.


## Resultados

Após execução dos testes foi posivel obter os valores do banchmark.

### Python+Flask+Gunicorn

Avg - Reqs/Sec: **8.692**

Tempo de execução: **9m 35s**

![python+flask+gunicorn](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/python%2Bflask%2Bgunicorn.png)


### Java+SpringBoot+Tomcat

Avg - Reqs/Sec: **42.170**

Tempo de execução: **1m 58s**

![java+springboot+tomcat](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bspringboot%2Btomcat.png)


### Javascript+Express

Avg - Reqs/Sec: **44.895**

Tempo de execução: **1m 51s**

![javascript+express](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/javascript%2Bexpress.png)


### Javascript+Restify

Avg - Reqs/Sec: **56.405**

Tempo de execução: **1m 28s**

![javascript+express](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/javascript%2Brestify.png)


### Java+SpringBoot+Undertow

Avg - Reqs/Sec: **59.363**

Tempo de execução: **1m 24s**

![java+springboot+undertow](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bspringboot%2Bundertow.png)


### Java+SpringBoot+Jetty

Avg - Reqs/Sec: **61.096**

Tempo de execução: **1m 21s**

![java+springboot+jetty](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bspringboot%2Bjetty.png)


### Java+SpringBoot+WebFlux+Netty

Avg - Reqs/Sec: **40.340**

Tempo de execução: **2m 3s**

![java+springboot+webflux+netty](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bspringboot%2Bwebflux%2Bnetty.png)


### Java+Quarkus+Native

Avg - Reqs/Sec: **48.102**

Tempo de execução: **1m 43s**

![java+quarkus+native](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bquarkus%2Bnative.png)


### Java+Http

Avg - Reqs/Sec: **78.671**

Tempo de execução: **1m 3s**

![java+http](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bhttp.png)


### Go+Http

Avg - Reqs/Sec: **96.232**

Tempo de execução: **51s**

![go+http](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/go%2Bhttp.png)


### Javascript+Http

Avg - Reqs/Sec: **100.190**

Tempo de execução: **49s**

![javascript+http](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/javascript%2Bhttp.png)


### Gráfico (Média de requests por segundo)

![grafico_01](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/grafico_01.png)


## Comandos para execução dos projetos e replicação

Para executar o projetos, você deve possuir as linguagens instaladas em sua maquina

#### Execução do projeto java+springboot+tomcat
    cd java+springboot+tomcat/
    ./gradlew build -x test
    java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar    

#### Execução do projeto java+springboot+jetty
    cd java+springboot+jetty/
    ./gradlew build -x test
    java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar    

#### Execução do projeto java+springboot+undertow
    cd java+springboot+undertow/
    ./gradlew build -x test
    java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar    

#### Execução do projeto java+springboot+webflux+netty
    cd java+springboot+webflux+netty/
    ./gradlew build -x test
    java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar    

#### Execução do projeto java+quarkus+native
    cd java+quarkus/
     ./mvnw clean package -Pnative
     ./target/rest-client-quickstart-1.0.0-SNAPSHOT-runner    

#### Execução do projeto java+http
    cd java+http/
    javac JavaHTTPServer.java
    java JavaHTTPServer    

#### Execução do projeto javascript+express
    cd javascript+express/
    npm install
    npm start

#### Execução do projeto javascript+restfy
    cd javascript+restify/
    npm install
    npm start

#### Execução do projeto go+http
    cd go+http
    go build server.go
    ./server

#### Execução do python+flask+gunicorn
    cd python+flask+gunicorn
    source venv/bin/activate
    pip install -r requirements.txt
    gunicorn --bind 127.0.0.1:6060 app:app -w 8 --worker-class=gevent --worker-connections=1000

#### Execução do projeto javascript+http
    cd javascript+http/
    npm install
    npm start


#### Execução do banchmark (5 milhões de requisições, 125 requisições em paralelo)
    
Testando a aplicação go+http

    bombardier -c 125 -n 5000000 http://localhost:7070/hello

Testando a aplicação java+springboot+tomcat

    bombardier -c 125 -n 5000000 http://localhost:8080/hello

Testando a aplicação java+springboot+jetty

    bombardier -c 125 -n 5000000 http://localhost:8181/hello

Testando a aplicação java+springboot+undertow

    bombardier -c 125 -n 5000000 http://localhost:8282/hello

Testando a aplicação java+springboot+webflux+netty

    bombardier -c 125 -n 5000000 http://localhost:8484/hello

Testando a aplicação java+quarkus+native

    bombardier -c 125 -n 5000000 http://localhost:8585/hello

Testando a aplicação java+http

    bombardier -c 125 -n 5000000 http://localhost:8383/hello

Testando a aplicação javascript+express

    bombardier -c 125 -n 5000000 http://localhost:9090/hello

Testando a aplicação javascript+restify

    bombardier -c 125 -n 5000000 http://localhost:9191/hello

Testando a aplicação javascript+http

    bombardier -c 125 -n 5000000 http://localhost:9292/hello

Testando a aplicação python+flask+gunicorn

    bombardier -c 125 -n 5000000 http://localhost:6060/hello



