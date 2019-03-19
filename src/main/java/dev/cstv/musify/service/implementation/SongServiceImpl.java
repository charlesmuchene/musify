package dev.cstv.musify.service.implementation;

import dev.cstv.musify.aop.ServiceValidation;
import dev.cstv.musify.dao.SongDao;
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
}
