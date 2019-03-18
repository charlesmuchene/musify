package dev.cstv.musify.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "releaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Song> songs = new ArrayList<Song>();

    public Album() {
    }

    public Album(String title, Date releaseDate, Collection<Song> songs) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.songs = songs;
    }

    public Album(String title, Date releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
