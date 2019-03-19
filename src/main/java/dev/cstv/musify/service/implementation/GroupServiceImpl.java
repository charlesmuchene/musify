package dev.cstv.musify.service.implementation;

import dev.cstv.musify.dao.GroupDao;
import dev.cstv.musify.domain.Group;
import dev.cstv.musify.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    public void save(Group group) {
        groupDao.save(group);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public List<Group> findAll() {
        return (List<Group>)groupDao.findAll();
    }
}
