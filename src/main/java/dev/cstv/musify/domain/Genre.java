package dev.cstv.musify.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Song> songs;

    public Genre() {
    }

    public Genre(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public Genre(String name) {
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

}
