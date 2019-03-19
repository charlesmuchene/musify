package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.aop.ServiceValidation;
import dev.cstv.musify.dao.ArtistDao;
import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistDao artistDao;

    @ServiceValidation
    @Override
    public void save(Artist artist) {

        artistDao.save(artist);
    }

    @Override
    public List<Artist> findAll() {

        return artistDao.findAll();
    }

    @ServiceValidation
    @Override
    public Artist update(Artist artist) {

        return artistDao.update(artist);
    }

    @Override
    public Artist findOne(long id) {

        return artistDao.findOne(id);
    }
}
