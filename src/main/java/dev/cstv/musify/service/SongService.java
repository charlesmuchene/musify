package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Song;

import java.util.List;

public interface SongService {

    public void save(Song song);

    public List<Song> findAll();

    public Song update(Song song);

    public Song findOne(long id);

    public Song play(Song song);

}
