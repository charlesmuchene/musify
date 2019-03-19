package dev.cstv.musify.resources;

import dev.cstv.musify.domain.Song;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongResource {

    @GET
    public List<Song> findAllSongs() {

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song());
        songs.add(new Song());
        songs.add(new Song());
        songs.add(new Song());
        return songs;
    }

    @POST
    public void save(Song song) {
        System.out.println("Pretend the song is saved");
    }

}
