package dev.cstv.musify.service.implementation;

import dev.cstv.musify.aop.ServiceValidation;
import dev.cstv.musify.dao.ChartDao;
import dev.cstv.musify.dao.SongDao;
import dev.cstv.musify.domain.Chart;
import dev.cstv.musify.domain.ChartSong;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SongServiceImpl implements SongService {

    @Autowired
    private SongDao songDao;

    @Autowired
    private ChartDao chartDao;

    @ServiceValidation
    @Override
    public void save(Song song) {
        songDao.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @ServiceValidation
    @Override
    public Song update(Song song) {

        return songDao.update(song);
    }

    @Override
    public Song findOne(long id) {
        return songDao.findOne(id);
    }

    @Override
    public Song play(Song song) {

        List<Chart> chartList = chartDao.findAll();

        chartList.forEach(chart -> {

            List<ChartSong> csongs=chart.getSongs();

            ChartSong chartSong = chart.getSongs().stream().filter(cs -> cs.getSong().equals(song)).findAny().get();

            if (chartSong != null) {

                long plays = chartSong.getPlays();

                chart.getSongs().get(chart.getSongs().indexOf(chartSong)).setPlays(plays + 1);

                chartDao.update(chart);
            }

        });

        return findOne(song.getId());
    }
}
