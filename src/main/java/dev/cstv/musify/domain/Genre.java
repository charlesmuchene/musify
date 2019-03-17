package dev.cstv.musify.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
