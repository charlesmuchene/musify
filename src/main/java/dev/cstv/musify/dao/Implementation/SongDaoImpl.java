package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.SongDao;
import dev.cstv.musify.domain.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SongDaoImpl extends GenericDaoImpl<Song> implements SongDao {

    public SongDaoImpl() {
        super.setDaoType(Song.class );
    }

}
