package dev.cstv.musify.resources;

import dev.cstv.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/play")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayResource {

    @Autowired
    private SongService songService;

    @POST
    @Path("/{id}")
    public void play(@PathParam("id") Long id) {
        songService.play(id);
    }
}
