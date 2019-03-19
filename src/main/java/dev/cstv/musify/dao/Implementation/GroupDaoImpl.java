package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.GroupDao;
import dev.cstv.musify.domain.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao {
    public GroupDaoImpl() {
        super.setDaoType(Group.class);
    }
}
