package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.UserDao;
import dev.cstv.musify.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        this.setDaoType(User.class);
    }
}
