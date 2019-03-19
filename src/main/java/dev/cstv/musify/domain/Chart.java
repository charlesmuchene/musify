package dev.cstv.musify.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Chart")
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chart_songs",joinColumns = @JoinColumn(name = "chart_id"),inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs = new ArrayList<Song>();

    public Chart() {
    }

    public Chart(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public Chart(String name) {
        this.name = name;
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
}
