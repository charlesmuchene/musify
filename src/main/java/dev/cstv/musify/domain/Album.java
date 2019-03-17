package dev.cstv.musify.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    private Long id;
    private String title;
    private Artist artist;
    private Date releaseDate;
    private List<Song> songs = new ArrayList<Song>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
