package Service;

import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.service.ArtistService;
import dev.cstv.musify.service.Implementation.ArtistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArtistServiceTest {


    ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");

    ArtistService artistService= (ArtistService) context.getBean("artistServiceImpl");

    @Test
    public void updateArtist(){

        Artist artist=artistService.findOne(1);
        artist.setName("Khaled");

        assertEquals(Artist.class,artistService.update(artist).getClass());
    }

    @Test
    public void getSingleArtist(){

        assertEquals(Artist.class,artistService.findOne(1).getClass());

    }


    @Test
    public void getAllArtists(){

        assertEquals(ArrayList.class,artistService.findAll().getClass());

    }

    @Test
    public void saveArtist(){

        Artist artist=new Artist("Khalid");

        artistService.save(artist);
    }

}
