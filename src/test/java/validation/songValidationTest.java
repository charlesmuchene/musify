package validation;

import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class songValidationTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    SongService songService=(SongService) context.getBean("songServiceImpl");

    @Test
    public void testAddSong(){

        Song song=new Song();
        song.setArtist(new Artist("Jabari"));
        song.setTitle("t");
        song.setUrl("http://localhost:8080/");
        song.setReleaseDate(new Date());
        song.setDuration(1);
        songService.save(song);

    }
}
