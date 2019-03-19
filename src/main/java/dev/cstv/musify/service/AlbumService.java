package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Album;

import java.util.List;

public interface AlbumService {

    public void save(Album album);

    public List<Album> findAll();

    public Album update(Album album);

    public Album findOne(long id);

}
