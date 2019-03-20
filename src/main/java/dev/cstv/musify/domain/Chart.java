package dev.cstv.musify.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Chart")
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "{NotNull}")
    @Length(min = 5, message = "{Length}")
    @Column(name = "name", nullable = false)
    private String name;

    //@JoinTable(name = "chart_songs",joinColumns = @JoinColumn(name = "chart_id"),inverseJoinColumns = @JoinColumn(name = "song_id"))
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "chart")
    private List<ChartSong> songs = new ArrayList<ChartSong>();

    public Chart() {
    }

    public Chart(String name, List<ChartSong> songs) {
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

    public List<ChartSong> getSongs() {
        return songs;
    }

    public void addSong(ChartSong song) {
        this.songs.add(song);
    }
}
