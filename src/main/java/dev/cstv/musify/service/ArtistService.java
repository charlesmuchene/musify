package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Artist;

import java.util.List;

public interface ArtistService {

    public void save(Artist user);

    public List<Artist> findAll();

    public Artist update(Artist user);

    public List<Artist> findAllJoinFetch();

    public List<Artist> findAllSubSelect();

}
