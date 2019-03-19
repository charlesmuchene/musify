package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.UserCredentialsDao;
import dev.cstv.musify.domain.UserCredentials;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<UserCredentials> implements UserCredentialsDao {

    public UserCredentialsDaoImpl(){
        super.setDaoType(UserCredentials.class);
    }

    public UserCredentials findByUserName(String userName) {
        Query query = entityManager.createQuery("select c from UserCredentials c  where c.username = :userName");

        return (UserCredentials) query.setParameter("userName", userName).getSingleResult();
    }

}
