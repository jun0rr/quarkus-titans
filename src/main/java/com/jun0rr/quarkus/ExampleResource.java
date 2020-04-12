package com.jun0rr.quarkus;

import com.jun0rr.quarkus.model.User;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("/{name : \\w+}")
    @Produces(MediaType.APPLICATION_JSON)
    public User hello(@PathParam("name") String name, @QueryParam("email") String email) {
      return new User(System.currentTimeMillis(), name, email);
    }
    
}