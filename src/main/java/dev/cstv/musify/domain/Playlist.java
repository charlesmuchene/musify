package dev.cstv.musify.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "{NotNull}")
    @Length(min = 3,message = "{Length}")
    @Column(name = "name", nullable = false)
    private String name;


    @NotNull(message = "{NotNull}")
    @Valid
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "playlist_songs", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"))
    private List<Song> songs = new ArrayList<Song>();

    public Playlist() {
    }

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist(String name, User user, List<Song> songs) {
        this.name = name;
        this.user = user;
        this.songs = songs;
    }

    public Playlist(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
