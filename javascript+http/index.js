const http = require("http")

const requestListener = function (req, res) {
    res.writeHead(200);
    res.end("hello");
};

const server = http.createServer(requestListener)
server.listen(9292, 'localhost')