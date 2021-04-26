FROM golang:1.10

COPY server.go app.go

RUN go build app.go

# This container exposes port 8080 to the outside world
EXPOSE 8080

# Run the executable
CMD ["./app"]