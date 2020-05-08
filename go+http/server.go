package main

import (
  "fmt"
  "net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
  fmt.Fprintf(w, "Hi there, %s!", r.URL.Path[1:])
}

func main() {
  http.HandleFunc("/", handler)
  fmt.Println("server is listening on 3331")
  http.ListenAndServe(":3331", nil)
}
