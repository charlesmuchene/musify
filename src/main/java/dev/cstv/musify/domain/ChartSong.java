package dev.cstv.musify.domain;

import javax.persistence.*;

@Entity
@Table(name = "chart_song")
@AssociationOverrides({
        @AssociationOverride(name = "chart", joinColumns = @JoinColumn(name = "chart_id")),
        @AssociationOverride(name = "song", joinColumns = @JoinColumn(name = "song_id"))
})
public class ChartSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Chart chart;

    @ManyToOne
    private Song song;

    @Column(name = "plays")
    private long plays;

    public ChartSong() {

    }

    public ChartSong(Chart chart, Song song) {
        this.chart = chart;
        this.song = song;
    }

    public long getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
