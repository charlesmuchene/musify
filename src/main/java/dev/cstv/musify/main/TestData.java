package dev.cstv.musify.main;

import dev.cstv.musify.domain.*;
import dev.cstv.musify.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TestData {

    @Autowired
    SongService songService;
    @Autowired
    ArtistService artistService;
    @Autowired
    GenreService genreService;
    @Autowired
    UserService userService;
    @Autowired
    ChartService chartService;

    public void load() {

        Artist artist = new Artist("Khaled");
        Artist sautiSol = new Artist("Sauti Sol");
        Artist lievTuk = new Artist("Liev Tuk");
        Artist thùyChi = new Artist("Thùy Chi");

        Genre popGenre = new Genre("Pop");
        Genre soulGenre = new Genre("Soul");
        Genre rockGenre = new Genre("Rock");
        Genre jazzGenre = new Genre("Jazz");
        Genre bluesGenre = new Genre("Blues");
        Genre classicalGenre = new Genre("Classical Music");
        Genre hiphopGenre = new Genre("Hip Hop");

        //Add All other genres
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(soulGenre);
        genres.add(popGenre);
        genres.add(rockGenre);
        genres.add(jazzGenre);
        genres.add(bluesGenre);
        genres.add(classicalGenre);
        genres.add(hiphopGenre);

        genres.forEach(genre -> {

            genreService.save(genre);
        });

        //getAllGenres
        genres = genreService.findAll();

        /*
        Create new Songs
         */
        Song song = new Song();
        song.setTitle("Better");
        song.setGenre(genres.get(0));
        song.setDuration(3);
        song.setReleaseDate(new Date(2013, 12, 2));
        song.setArtist(artist);

        Song cSong = new Song();
        cSong.setTitle("Rom Sue Sue");
        cSong.setGenre(genres.get(1));
        cSong.setDuration(4);
        cSong.setReleaseDate(new Date(2013, 12, 2));
        cSong.setArtist(lievTuk);

        Song vSong = new Song();
        vSong.setTitle("Mong Manh Tinh Ve");
        vSong.setGenre(genres.get(1));
        vSong.setDuration(4);
        vSong.setReleaseDate(new Date(2013, 12, 2));
        vSong.setArtist(thùyChi);

        Song sautiSong = new Song();
        sautiSong.setTitle("Short N' Sweet");
        sautiSong.setGenre(genres.get(1));
        sautiSong.setDuration(3);
        sautiSong.setReleaseDate(new Date(2013, 12, 2));
        sautiSong.setArtist(sautiSol);


        //Songs in Album
        Song secondSong = new Song();
        secondSong.setTitle("Song in Album");
        secondSong.setGenre(genres.get(4));
        secondSong.setDuration(3);
        secondSong.setReleaseDate(new Date(2013, 12, 2));
        secondSong.setArtist(artist);

        Song thirdSong = new Song();
        thirdSong.setTitle("My Third song");
        thirdSong.setGenre(genres.get(6));
        thirdSong.setDuration(3);
        thirdSong.setReleaseDate(new Date(2013, 12, 2));
        thirdSong.setArtist(artist);

        //Add Song to Artist Object
        artist.addSong(song);
        sautiSol.addSong(sautiSong);
        thùyChi.addSong(vSong);
        lievTuk.addSong(cSong);

        //Add Album to Artist Object
        Album album = new Album("My First Album", new Date(3, 12, 2018));
        album.addSong(secondSong);

        Album secondAlbum = new Album("My Second Album", new Date(19, 12, 8));
        secondAlbum.addSong(thirdSong);

        artist.addAlbum(album);
        artist.addAlbum(secondAlbum);

        //Save Artist(s)
        artistService.save(artist);
        artistService.save(thùyChi);
        artistService.save(lievTuk);
        artistService.save(sautiSol);

        /*
          Create a chart
         */
        Chart chart = new Chart("Top 50 Iowa Hits");
        chart.addSong(song);
        chart.addSong(sautiSong);

        chartService.save(chart);

        /*
        /Dummy data for Users
        Create a new User
        */

        User user = new User("Steven", "Katabalwa");
        UserCredentials stevenCredentials = new UserCredentials(user, "stev", "stev", "stev@mail.com");
        user.setUserCredentials(stevenCredentials);
        userService.save(user);

        User secondUser = new User("Vorleak", "Chy");
        UserCredentials vorleakCredentials = new UserCredentials(secondUser, "vorleak", "vorleak", "vorleak@mail.com");
        secondUser.setUserCredentials(vorleakCredentials);
        userService.save(secondUser);

        User charlo = new User("Charles", "Muchene");
        UserCredentials charlesCredentials = new UserCredentials(charlo, "charlo", "charlo", "charlo@mail.com");
        charlo.setUserCredentials(charlesCredentials);
        userService.save(charlo);

        User fourthUser = new User("Tuy", "Vo");
        UserCredentials tuyCredentials = new UserCredentials(fourthUser, "tuy", "tuy", "tuy@mail.com");
        fourthUser.setUserCredentials(tuyCredentials);
        userService.save(fourthUser);

        /*
        /
        Create a playList for a user
         */
        Playlist playlist = new Playlist("Steven's Playlist", user);

        List<Song> songs = songService.findAll();

        songs.forEach(s -> {

            playlist.addSong(s);
        });

        user.addPlaylist(playlist);
        userService.update(user);

        Playlist charloPlaylist = new Playlist("Charlo's Playlist", charlo);

        Song fSong = songService.findOne(2);

        charloPlaylist.addSong(fSong);

        charlo.getPlaylists().add(charloPlaylist);

        userService.update(charlo);

        List<Song> songList = songService.findAll();

        Chart currentChart = chartService.findOne(1);
    }


}
