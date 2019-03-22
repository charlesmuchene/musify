package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.SongDao;
import dev.cstv.musify.domain.Song;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class SongDaoImpl extends GenericDaoImpl<Song> implements SongDao {

    public SongDaoImpl() {
        super.setDaoType(Song.class );
    }

    @Override
    public List<Song> findAllBySubSelect() {

        return this.entityManager.createQuery("select s from Song s join fetch Genre g on g.id=s.genre join fetch Artist a on a.id=s.artist",Song.class).getResultList();
    }
    
    @Override
    public Song findByTitle(String title) {
    	Query query =  entityManager.createQuery("select s from Song s where title = :title ");
    	query.setParameter("title", title);
    	List result = query.getResultList();
    	return CollectionUtils.isEmpty(query.getResultList()) ? null : (Song) result.get(0);
    }
}
