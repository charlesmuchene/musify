package service;

import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.Genre;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SongServiceTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    SongService songService=(SongService)context.getBean("songServiceImpl");

    @Test
    public void saveSong() {

        Artist artist=new Artist("Khaled");

        Genre genre = new Genre("Pop");

        Song song = new Song();
        song.setTitle("Better");
        //song.setGenre(genre);
        song.setUrl("http://localhost:8080/");
        song.setDuration(3);
        song.setReleaseDate(new Date(2013,12,2));
        song.setArtist(artist);

        songService.save(song);

        Song song1=songService.findOne(1);

        songService.play(songService.findOne(1));

    }



}