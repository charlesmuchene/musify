package dev.cstv.musify.resources;

import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("songs")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongResource {

    @Autowired
    private SongService songService;

    @GET
    public List<Song> findAllSongs() {
        return songService.findAll();
    }

    @POST
    public void save(Song song) {
        songService.save(song);
    }

}
