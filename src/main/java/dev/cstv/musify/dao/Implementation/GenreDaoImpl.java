package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.domain.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreDaoImpl extends GenericDaoImpl<Genre> {

    public GenreDaoImpl() {

        this.setDaoType(Genre.class);
    }
}
