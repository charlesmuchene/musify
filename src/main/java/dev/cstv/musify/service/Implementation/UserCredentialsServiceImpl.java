package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.dao.UserCredentialsDao;
import dev.cstv.musify.domain.UserCredentials;
import dev.cstv.musify.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Override
    public void save(UserCredentials userCredentials) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userCredentials.getPassword());
        userCredentials.setPassword(encodedPassword);

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

    @Override
    public UserCredentials findByUserName(String userName) {
        return userCredentialsDao.findByUserName(userName);
    }

    public UserCredentials findOne(long id) {
        return userCredentialsDao.findOne(id);
    }
}
