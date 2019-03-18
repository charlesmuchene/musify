package dev.cstv.musify.service.Implementation;

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

    @Override
    public void save(Song song) {

        songDao.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public Song update(Song song) {

        return songDao.update(song);
    }
}
