package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Artist;

import java.util.List;

public interface ArtistService {

    public void save(Artist artist);

    public List<Artist> findAll();

    public Artist update(Artist artist);

    public Artist findOne(long id);


}
