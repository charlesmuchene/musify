package dev.cstv.musify.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "song")
    private List<ChartSong> chartSongs = new ArrayList<>();

    public List<ChartSong> getChartSongs() {
        return chartSongs;
    }

    public void addChartSong(ChartSong chartSong) {
        this.chartSongs.add(chartSong);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(genre, song.genre) &&
                Objects.equals(url, song.url) &&
                Objects.equals(album, song.album) &&
                Objects.equals(duration, song.duration) &&
                Objects.equals(releaseDate, song.releaseDate) &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(chartSongs, song.chartSongs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, url, album, duration, releaseDate, artist, chartSongs);
    }

    public static class Builder {
        private Song song;

        public Builder() {
            song = new Song();
        }

        public Builder setTitle(String title) {
            song.title = title;
            return this;
        }

        public Builder setGenre(Genre genre) {
            song.genre = genre;
            return this;
        }

        public Builder setDuration(Integer duration) {
            song.duration = duration;
            return this;
        }

        public Builder setUrl(String url) {
            song.url = url;
            return this;
        }

        public Builder setReleaseDate(Date releaseDate) {
            song.releaseDate = releaseDate;
            return this;
        }

        public Builder setArtist(Artist artist) {
            song.artist = artist;
            return this;
        }

        public Song build() {
            return song;
        }
    }
}
