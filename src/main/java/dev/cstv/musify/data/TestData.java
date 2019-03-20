package dev.cstv.musify.data;

import dev.cstv.musify.domain.*;
import dev.cstv.musify.messaging.mail.MailTask;
import dev.cstv.musify.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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

    @Autowired
    MailTask mailTask;

    @Autowired
    GroupService groupService;

    public void load() {

        Artist artist = new Artist("Khaled");
        Artist sautiSol = new Artist("Sauti Sol");
        Artist lievTuk = new Artist("Liev Tuk");
        Artist thuyChi = new Artist("Thùy Chi");
        Artist virtualArtist = new Artist("Virtual Artist");

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_MONTH, 2);

        Song song = new Song();
        song.setTitle("Better");
        song.setGenre(genres.get(0));
        song.setDuration(3);
        song.setUrl("http://127.0.0.1:5500/resources/music/1.mp3");
        song.setReleaseDate(calendar.getTime());
        song.setArtist(artist);

        Song cSong = new Song();
        cSong.setTitle("Rom Sue Sue");
        cSong.setGenre(genres.get(1));
        cSong.setDuration(4);
        cSong.setUrl("http://127.0.0.1:5500/resources/music/2.mp3");
        cSong.setReleaseDate(calendar.getTime());
        cSong.setArtist(lievTuk);

        Song vSong = new Song();
        vSong.setTitle("Mong Manh Tinh Ve");
        vSong.setGenre(genres.get(1));
        vSong.setDuration(4);
        vSong.setUrl("http://127.0.0.1:5500/resources/music/1.mp3");
        vSong.setReleaseDate(calendar.getTime());
        vSong.setArtist(thuyChi);

        Song sautiSong = new Song();
        sautiSong.setTitle("Short N' Sweet");
        sautiSong.setGenre(genres.get(1));
        sautiSong.setDuration(3);
        sautiSong.setUrl("http://127.0.0.1:5500/resources/music/2.mp3");
        sautiSong.setReleaseDate(calendar.getTime());
        sautiSong.setArtist(sautiSol);

        //Songs in Album
        Song secondSong = new Song();
        secondSong.setTitle("BatchSong in Album");
        secondSong.setGenre(genres.get(4));
        secondSong.setDuration(3);
        secondSong.setUrl("http://127.0.0.1:5500/resources/music/1.mp3");
        secondSong.setReleaseDate(calendar.getTime());
        secondSong.setArtist(artist);

        Song thirdSong = new Song();
        thirdSong.setTitle("My Third song");
        thirdSong.setGenre(genres.get(6));
        thirdSong.setDuration(3);
        thirdSong.setUrl("http://127.0.0.1:5500/resources/music/2.mp3");
        thirdSong.setReleaseDate(calendar.getTime());
        thirdSong.setArtist(artist);

        //Add BatchSong to Artist Object
        artist.addSong(song);
        sautiSol.addSong(sautiSong);
        thuyChi.addSong(vSong);
        lievTuk.addSong(cSong);

        //songService.save(virtualSong);
        Calendar albumCalendar = Calendar.getInstance();
        albumCalendar.set(2018, Calendar.DECEMBER, 3);
        //Add Album to Artist Object
        Album album = new Album("My First Album", albumCalendar.getTime());
        // album.addSong(secondSong);
        albumCalendar.set(2019, Calendar.DECEMBER, 8);
        Album secondAlbum = new Album("My Second Album", albumCalendar.getTime());
        //  secondAlbum.addSong(thirdSong);
        secondAlbum.addSong(song);

        artist.addAlbum(album);
        artist.addAlbum(secondAlbum);

        //Save Artist(s)
        artistService.save(artist);
        artistService.save(thuyChi);
        artistService.save(lievTuk);
        artistService.save(sautiSol);

        /*
          Create a chart
         */
        Chart chart = new Chart("Top 50 Iowa Hits");
        ChartSong chartSong=new ChartSong(chart,song);
        ChartSong chartSong2=new ChartSong(chart,sautiSong);

        chart.addSong(chartSong);
        chart.addSong(chartSong2);
        
        chartService.save(chart);

        /*
        * Init group user and authorities
        * */
        Group groupUser = new Group();
        groupUser.setName("User");

        Authority authority = new Authority();
        authority.setAuthority("create");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("update");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("delete");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("list");
        groupUser.getAuthority().add(authority);

        /*
        /Dummy data for Users
        Create a new User
        */

        User user = new User("Steven", "Katabalwa");
        UserCredentials stevenCredentials = new UserCredentials(user, "stev", "stev", "stev@mail.com");
        user.setUserCredentials(stevenCredentials);
        userService.saveFull(user);

        User secondUser = new User("Vorleak", "Chy");
        UserCredentials vorleakCredentials = new UserCredentials(secondUser, "vorleak", "vorleak", "vorleak@mail.com");
        secondUser.setUserCredentials(vorleakCredentials);
        userService.saveFull(secondUser);

        User charlo = new User("Charles", "Muchene");
        UserCredentials charlesCredentials = new UserCredentials(charlo, "charlo", "charlo", "charlo@mail.com");
        charlo.setUserCredentials(charlesCredentials);
        userService.saveFull(charlo);

        User fourthUser = new User("Tuy", "Vo");
        UserCredentials tuyCredentials = new UserCredentials(fourthUser, "tuy", "tuy", "tuy@mail.com");
        fourthUser.setUserCredentials(tuyCredentials);
        userService.saveFull(fourthUser);

        UserCredentials johnUserCredentials = new UserCredentials("john", "john", "john@musify.com");
        User johnUser = new User("John", "Smith", johnUserCredentials);
        userService.saveFull(johnUser);

        UserCredentials paulUserCredentials = new UserCredentials("paul", "paul", "paul@musify.com");
        User paulUser = new User("Paul", "Smith", paulUserCredentials);
        userService.saveFull(paulUser);

        groupUser.getUserCredentials().add(stevenCredentials);
        groupUser.getUserCredentials().add(vorleakCredentials);
        groupUser.getUserCredentials().add(charlesCredentials);
        groupUser.getUserCredentials().add(tuyCredentials);
        groupUser.getUserCredentials().add(johnUserCredentials);
        groupUser.getUserCredentials().add(paulUserCredentials);

        /*
        Create a playList for a user
         */
        Playlist playlist = new Playlist("Steven's Playlist", user);

        List<Song> songs = songService.findAll();

        songs.forEach(playlist::addSong);

        user.addPlaylist(playlist);
        userService.update(user);

        Playlist charloPlaylist = new Playlist("Charlo's Playlist", charlo);

        Song fSong = songService.findOne(2);

        charloPlaylist.addSong(fSong);

        charlo.getPlaylists().add(charloPlaylist);

        userService.update(charlo);

        /*
         * Create user group
         * */
        groupService.save(groupUser);

        System.out.println("*** Loaded Dummy Data ***");

        Chart chart1=chartService.findOne(1);

        songService.play(sautiSong);

        mailTask.setRoutingKey("chart.mail");

        mailTask.sendMail(userService.findOne(1),null,chartService.findOne(1));


    }
}
