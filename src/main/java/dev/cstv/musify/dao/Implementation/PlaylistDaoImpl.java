package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.dao.PlaylistDao;
import dev.cstv.musify.domain.Playlist;
import org.springframework.stereotype.Repository;

@Repository
public class PlaylistDaoImpl extends GenericDaoImpl<Playlist> implements PlaylistDao {
    public PlaylistDaoImpl() {
        super.setDaoType(Playlist.class);
    }
}
