package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.dao.UserDao;
import dev.cstv.musify.domain.User;
import dev.cstv.musify.domain.UserCredentials;
import dev.cstv.musify.service.UserCredentialsService;
import dev.cstv.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserCredentialsService userCredentialsService;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void saveFull(User user) {
        userCredentialsService.save(user.getUserCredentials());
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public User findOne(long id) {

        return userDao.findOne(id);
    }

    @Override
    public User findAllBySubSelect() {

        return null;
    }
}
