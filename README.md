# Comparação performática entre diferêntes frameworks e linkguagens
Após ler essa página [Benchmarking Node.js Http Performance Part 1 Express.js](https://mamaz.github.io/benchmarking-nodejs-http-performance.html) eu fiquei curioso em replicar estes testes com as linguagens de programação que eu estou utilizando recentemente.

# Instalação da ferramenta de benchmark (Bombardier)
https://softwaretester.info/http-benchmarking-with-bombardier/

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



  