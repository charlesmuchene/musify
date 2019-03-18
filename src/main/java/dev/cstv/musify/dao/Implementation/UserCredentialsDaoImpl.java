package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.UserCredentialsDao;
import dev.cstv.musify.domain.UserCredentials;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<UserCredentials> implements UserCredentialsDao {

    public UserCredentialsDaoImpl(){
        this.setDaoType(UserCredentials.class);
    }

}
