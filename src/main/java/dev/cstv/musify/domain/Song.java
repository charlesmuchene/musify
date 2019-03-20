package dev.cstv.musify.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    @NotNull(message = "{NotNull}")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre")
    @JsonIgnore
    private Genre genre;

    @NotNull(message = "{NotNull}")
    @URL(message = "{URL}")
    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album")
    @JsonIgnore
    private Album album;

    @NotNull
    @Range(min = 1, max = 10, message = "{Duration}")
    @Column(name = "duration")
    private Integer duration;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    private Date releaseDate;

    @NotNull(message = "{NotNull}")
    @Valid
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist")
    @JsonIgnore
    private Artist artist;

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
