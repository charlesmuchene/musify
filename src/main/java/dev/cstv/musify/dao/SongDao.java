package dev.cstv.musify.dao;

import dev.cstv.musify.domain.Song;

import java.util.List;

public interface SongDao extends GenericDao<Song> {

        public List<Song> findAllBySubSelect();

}
