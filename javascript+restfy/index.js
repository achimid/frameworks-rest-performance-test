const restify = require('restify');
const server = restify.createServer()

server.get('/hello', (req, res, next) => {
    res.send('hello')
    next()
})

server.listen(8080)