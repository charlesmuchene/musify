package dev.cstv.musify.service;

import dev.cstv.musify.dao.GenericDao;
import dev.cstv.musify.domain.Chart;

import java.util.List;

public interface ChartService {

    public void save(Chart chart);

    public List<Chart> findAll();

    public Chart update(Chart chart);

    public Chart findOne(long id);

}
