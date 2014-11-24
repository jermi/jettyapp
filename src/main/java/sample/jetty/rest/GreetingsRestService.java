package sample.jetty.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.jetty.service.GreetingsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by kkoziel on 2014-11-24.
 */
@Path("")
@Component
public class GreetingsRestService {

    @Autowired
    private GreetingsService greetingsService;

    @Path("/hello")
    @GET
    public String message() {
        return greetingsService.getHelloMessage() + " from REST!";
    }

    @Path("/greet")
    @GET
    public String greet(@QueryParam("name") String name) {
        return greetingsService.greet(name);
    }

}
