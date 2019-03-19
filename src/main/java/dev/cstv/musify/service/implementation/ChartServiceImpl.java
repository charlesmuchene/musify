package dev.cstv.musify.service.implementation;

import dev.cstv.musify.aop.ServiceValidation;
import dev.cstv.musify.dao.ChartDao;
import dev.cstv.musify.domain.Chart;
import dev.cstv.musify.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartDao chartDao;

    @ServiceValidation
    @Override
    public void save(Chart chart) {
        chartDao.save(chart);
    }

    @Override
    public List<Chart> findAll() {

        return chartDao.findAll();
    }

    @ServiceValidation
    @Override
    public Chart update(Chart chart) {
        return chartDao.update(chart);
    }

    @Override
    public Chart findOne(long id) {
        return chartDao.findOne(id);
    }
}
