package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.AlbumDao;
import dev.cstv.musify.domain.Album;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumDaoImpl extends GenericDaoImpl<Album> implements AlbumDao {

        public AlbumDaoImpl(){
            this.setDaoType(Album.class);
        }

}
