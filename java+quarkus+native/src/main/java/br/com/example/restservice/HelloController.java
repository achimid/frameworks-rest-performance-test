package br.com.example.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloController {

    @GET
    public String test() {
        return "hello";
    }

}
