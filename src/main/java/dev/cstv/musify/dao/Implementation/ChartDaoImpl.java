package dev.cstv.musify.dao.Implementation;

import dev.cstv.musify.dao.ChartDao;
import dev.cstv.musify.domain.Chart;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDaoImpl extends GenericDaoImpl<Chart> implements ChartDao {

    public ChartDaoImpl() {
        this.setDaoType(Chart.class);
    }
}
