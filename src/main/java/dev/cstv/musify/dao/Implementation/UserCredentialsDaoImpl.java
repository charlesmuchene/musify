package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.domain.UserCredentials;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<UserCredentials> {

    public UserCredentialsDaoImpl(){
        this.setDaoType(UserCredentials.class);
    }

}
