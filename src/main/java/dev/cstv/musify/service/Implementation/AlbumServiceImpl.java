package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.dao.AlbumDao;
import dev.cstv.musify.domain.Album;
import dev.cstv.musify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void save(Album album) {

        albumDao.save(album);
    }

    @Override
    public List<Album> findAll() {

        return albumDao.findAll();

    }

    @Override
    public Album update(Album album) {

        return albumDao.update(album);
    }

}
