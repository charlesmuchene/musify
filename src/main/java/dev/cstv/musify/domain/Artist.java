package dev.cstv.musify.domain;

import java.util.List;

public class Artist {
    private Long id;
    private String name;
    private List<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}