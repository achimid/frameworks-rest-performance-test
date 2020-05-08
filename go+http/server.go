package main

import (
  "fmt"
  "net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
  fmt.Fprintf(w, "hello", r.URL.Path[1:])
}

func main() {
  http.HandleFunc("/hello", handler)
  fmt.Println("server is listening on 7070")
  http.ListenAndServe(":7070", nil)
}
