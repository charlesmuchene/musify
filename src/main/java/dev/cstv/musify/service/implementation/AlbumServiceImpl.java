package dev.cstv.musify.service.implementation;

import dev.cstv.musify.aop.ServiceValidation;
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

    @ServiceValidation
    @Override
    public void save(Album album) {

        albumDao.save(album);
    }

    @Override
    public List<Album> findAll() {

        return albumDao.findAll();

    }

    @ServiceValidation
    @Override
    public Album update(Album album) {

        return albumDao.update(album);
    }

    @Override
    public Album findOne(long id) {
        return albumDao.findOne(id);
    }

}
