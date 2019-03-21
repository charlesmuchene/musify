package dev.cstv.musify.messaging;

import dev.cstv.musify.aop.Log;
import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.BatchSong;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class SongQueueListener {

    @Autowired
    SongService songService;

    @Log(message = "BatchSong has been received")
    public void listen(BatchSong Bsong) {

        Bsong.setDuration(3);

        Song song = new Song();
        song.setTitle(Bsong.getTitle());
        //song.setGenre(new Genre());
        song.setDuration(Bsong.getDuration());
        song.setUrl(Bsong.getUrl());
        Calendar c=Calendar.getInstance();
        c.set(2012,2,12);
        song.setReleaseDate(c.getTime());
        song.setArtist(new Artist("Some Artist"));

        songService.save(song);

       System.out.println("Batch Song has been received: " + song.getTitle());
    }
}
