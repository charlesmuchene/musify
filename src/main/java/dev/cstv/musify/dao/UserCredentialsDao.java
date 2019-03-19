package dev.cstv.musify.dao;

import dev.cstv.musify.domain.UserCredentials;

public interface UserCredentialsDao extends GenericDao<UserCredentials> {
    public UserCredentials findByUserName(String userName);
}
