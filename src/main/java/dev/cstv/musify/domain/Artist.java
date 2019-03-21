package dev.cstv.musify.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    @NotNull(message = "{NotNull}")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = EAGER,mappedBy = "artist")
    @Fetch(FetchMode.SUBSELECT)
    private List<Song> songs = new ArrayList<Song>();

    @OneToMany(cascade = CascadeType.ALL,fetch = EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "artist")
    private List<Album> albums = new ArrayList<Album>();

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
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

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {

        this.songs.add(song);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                ", albums=" + albums +
                '}';
    }
}