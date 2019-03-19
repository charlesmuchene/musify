package dev.cstv.musify.service.implementation;

import dev.cstv.musify.dao.PlaylistDao;
import dev.cstv.musify.domain.Playlist;
import dev.cstv.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistDao playlistDao;

    @Override
    @PreAuthorize("hasAuthority('create')")
    public void save(Playlist playlist) {
        playlistDao.save(playlist);
    }

    @Override
    @PreAuthorize("hasPermission(#playlist,'update')")
    public void update(Playlist playlist) {
        playlistDao.update(playlist);
    }

    @Override
    @PreAuthorize("hasPermission(#playlist,'delete')")
    public void delete(Playlist playlist) {
        playlistDao.delete(playlist.getId());
    }

    @Override
    @PreAuthorize("hasAuthority('list')")
    public List<Playlist> findAll() {
        return (List<Playlist>)playlistDao.findAll();
    }
}
