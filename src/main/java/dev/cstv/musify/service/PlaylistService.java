package dev.cstv.musify.service;

import dev.cstv.musify.domain.Playlist;

import java.util.List;

public interface PlaylistService {
    public void save(Playlist playlist);
    public void update(Playlist playlist);
    
    public void delete(Playlist playlist);
    public List<Playlist> findAll();
}
