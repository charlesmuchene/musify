package dev.cstv.musify.messaging;

import dev.cstv.musify.aop.Log;
import dev.cstv.musify.domain.Song;

public class SongQueueListener {

    @Log(message = "Song has been received")
    public void listen(Song song) {

        System.out.println("Song has been received");
    }
}
