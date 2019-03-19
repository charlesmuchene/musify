package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public List<User> findAll();

    public User update(User user);

    public User findOne(long id);
}
