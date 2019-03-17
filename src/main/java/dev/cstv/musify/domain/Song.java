package dev.cstv.musify.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Song")
public class Song {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Genre genre;

    @JoinColumn(name = "id")
    @Column(name = "artist", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Artist artist;

    @JoinColumn(name = "id")
    @Column(name = "album")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Album album;

    @Column(name = "duration")
    private Integer duration;

    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    private Date releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
