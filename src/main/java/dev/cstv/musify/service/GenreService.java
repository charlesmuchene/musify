package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Genre;

import java.util.List;

public interface GenreService {

    public void save(Genre genre);

    public List<Genre> findAll();

    public Genre update(Genre genre);

    public Genre findOne(long id);
}
