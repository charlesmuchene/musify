package dev.cstv.musify.domain;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs = new ArrayList<Song>();
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public User getUser() {
        return user;
    }
}
