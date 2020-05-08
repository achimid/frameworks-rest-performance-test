# Comparação performática entre diferêntes frameworks e linkguagens

## Motivação
Após ler essa página/artigo "[Benchmarking Node.js Http Performance Part 1 Express.js](https://mamaz.github.io/benchmarking-nodejs-http-performance.html)" eu fiquei curioso em replicar estes testes com as linguagens de programação que eu estou utilizando recentemente. E pessoalmentea acredito que a melhor maneira de aprender é fazendo.

## Objetivo/Descrição
Tenho como objetivo o aprendizado de utilização da ferramenta de benchmark [Bombardier](https://github.com/codesenberg/bombardier) e a comparação entre as linguagens e os frameworks que eu utilizei recentemente. Para fins de aprendizado acredito que a execução destes testes possui a credibilidade necessário.

Para a realização dos teste, eu criei 4 aplicações em diferentes linguagens e frameworks que realizam a mesma ação. A aplicação é responsavel por receber uma requisição HTTP seguindo o protocolo REST e dar como resposta um texto estático escrito "hello".

* Java + Spring Boot + Embed Toncat
* Javascript (NodeJS) + Express
* Go + Http
* Python + Flask + Gunicorn







## Ferramenta de benchmark (Bombardier)
Seguindo a recomendação do artigo mencionado, utilizei como ferramenta de benchmark o (Bombardier), é uma ferramenta escrita em GO que fica responsavel por enviar as requisições de teste para as aplicações que será testada, com ela é possivel simular grandes quantidades de requisições paralelas. Ao final da execução é exibido um relatório informando os dados coletados.

No meu caso eu utilizei como quesito de comparação a média de requisições por segundos (Avg - Reqs/Sec).

Para efeutar a instalação da ferramenta eu segui este [link](https://softwaretester.info/http-benchmarking-with-bombardier/)

No artigo mencionado anteriormente e tambem nos meus testes, a ferramente foi configurada para efetuar um total de 5.000.000 requisições, com 125 requisições em paralelo.


## Expecificações da maquina de teste


# Comandos para execução dos projetos

Para executar o projetos, você deve possuir as linguagens instaladas em sua maquina:
Links para instalação das linguagens:
    - 
    - 
    - 

# Execução do projeto java+springboot
    cd java+springboot/
    ./gradlew build -x test
    java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar    

# Execução do projeto javascript+express
    cd javascript+express/
    npm install
    npm start

# Execução do projeto go+http
    cd go+http
    go build server.go
    ./server

# Execução do python+flask+gunicorn
    cd python+flask+gunicorn
    source venv/bin/activate
    pip install -r requirements.txt
    gunicorn --bind 127.0.0.1:6060 app:app -w 8 --worker-class=gevent --worker-connections=1000

# Execução do banchmark (5 milhões de requisições, 125 requisições em paralelo)
    
Testando a aplicação go+http

    bombardier -c 125 -n 5000000 http://localhost:7070/hello

Testando a aplicação java+springboot

    bombardier -c 125 -n 5000000 http://localhost:8080/hello

Testando a aplicação javascript+express

    bombardier -c 125 -n 5000000 http://localhost:9090/hello

Testando a aplicação python+flask+gunicorn

    bombardier -c 125 -n 5000000 http://localhost:6060/hello



![machine-specs](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/machine-specs.png)
![python+flask+gunicorn](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/python%2Bflask%2Bgunicorn.png)
![java+springboot](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/java%2Bspringboot.png)
![javascript+express](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/javascript%2Bexpress.png)
![go+http](https://github.com/achimid/frameworks-rest-performance-test/blob/master/_imagens/go%2Bhttp.png)