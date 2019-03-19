package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.UserCredentials;

import java.util.List;

public interface UserCredentialsService {

    public void save(UserCredentials userCredentials);

    public List<UserCredentials> findAll();

    public UserCredentials update(UserCredentials userCredentials);

    public UserCredentials findByUserName(String userName);

}
