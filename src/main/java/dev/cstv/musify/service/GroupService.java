package dev.cstv.musify.service;

import dev.cstv.musify.domain.Group;

import java.util.List;

public interface GroupService {
    public void save(Group group);
    public void update(Group group);
    public List<Group> findAll();
}

