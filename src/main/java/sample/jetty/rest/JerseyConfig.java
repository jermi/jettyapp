package sample.jetty.rest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by kkoziel on 2014-11-24.
 */
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GreetingsRestService.class) ;
    }

}
