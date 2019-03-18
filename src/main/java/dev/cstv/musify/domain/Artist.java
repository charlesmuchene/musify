package dev.cstv.musify.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<Song> songs = new ArrayList<Song>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<Album> albums = new ArrayList<Album>();

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {

        this.songs.add(song);
    }
}