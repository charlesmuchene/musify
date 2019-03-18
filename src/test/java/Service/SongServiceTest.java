package Service;

import dev.cstv.musify.domain.Album;
import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.ArtistService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;

public class SongServiceTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    ArtistService artistService = (ArtistService) context.getBean("artistServiceImpl");


    @Test
    public void saveSong() {

        Artist artist = artistService.findOne(1);

        Album album=new Album("Khalid Music",new Date(2017,2,12),new ArrayList<Song>());

        Song song = new Song();
        song.setTitle("Better");

        Song song1 =new Song();
        song1.setTitle("On My Mind");

        artist.addSong(song);

        artist.addSong(song1);

        artist.addAlbum(new Album("Taki taki",new Date(2018,2,18),artist.getSongs()));

        artistService.update(artist);

    }
}