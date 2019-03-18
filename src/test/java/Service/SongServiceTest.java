package Service;

import dev.cstv.musify.domain.*;
import dev.cstv.musify.service.ArtistService;
import dev.cstv.musify.service.ChartService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SongServiceTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    ArtistService artistService = (ArtistService) context.getBean("artistServiceImpl");
    ChartService chartService=(ChartService)context.getBean("chartServiceImpl");


    @Test
    public void saveSong() {

        Artist newArtist=new Artist("Khaled");
        artistService.save(newArtist);

        Artist artist = artistService.findOne(1);

        Genre genre = new Genre("Pop");
        Genre genre1=new Genre("HipHop");

        Album album = new Album("Khalid Music", new Date(2017, 2, 12), new ArrayList<Song>());

        Song song = new Song();
        song.setTitle("Better");
        song.setGenre(genre);
        song.setDuration(3);
        song.setReleaseDate(new Date(2013,12,2));

        Song song1 = new Song();
        song1.setTitle("On My Mind");
        song1.setGenre(genre1);

        artist.addSong(song);

        artist.addSong(song1);

        artist.addAlbum(new Album("Taki taki", new Date(2018, 2, 18), artist.getSongs()));

        artistService.update(artist);

        List<Song> songs= (List<Song>) artistService.findOne(1).getSongs();

        Chart chart=new Chart("Top MUM Songs",songs);

        chartService.save(chart);



    }
}