package dev.cstv.musify.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PlayResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Welcome to CSTV API. Hit your preferred end point!";
    }
}
