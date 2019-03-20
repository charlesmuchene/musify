package service;

import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.Genre;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class SongServiceTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    private SongService songService = (SongService) context.getBean("songServiceImpl");

    @Test
    public void saveSong() {

        Artist artist = new Artist("Khaled");

        Song song = new Song();
        song.setTitle("Better");
        song.setUrl("http://localhost:8080/");
        song.setDuration(3);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.DECEMBER, 2);
        song.setReleaseDate(calendar.getTime());
        song.setArtist(artist);

        songService.save(song);

        songService.play(1L);

    }


}