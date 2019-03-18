package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.dao.UserCredentialsDao;
import dev.cstv.musify.domain.UserCredentials;
import dev.cstv.musify.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Override
    public void save(UserCredentials userCredentials) {

        userCredentialsDao.save(userCredentials);
    }

    @Override
    public List<UserCredentials> findAll() {
        return userCredentialsDao.findAll();
    }

    @Override
    public UserCredentials update(UserCredentials userCredentials) {
        return userCredentialsDao.update(userCredentials);
    }
}
