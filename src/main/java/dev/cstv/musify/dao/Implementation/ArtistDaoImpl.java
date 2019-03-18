package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.ArtistDao;
import dev.cstv.musify.domain.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDaoImpl extends GenericDaoImpl<Artist> implements ArtistDao {

    public ArtistDaoImpl() {
        super.setDaoType(Artist.class);
    }

}
