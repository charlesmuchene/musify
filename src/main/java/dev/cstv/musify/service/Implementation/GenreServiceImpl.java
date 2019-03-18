package dev.cstv.musify.service.Implementation;

import dev.cstv.musify.dao.GenreDao;
import dev.cstv.musify.domain.Genre;
import dev.cstv.musify.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public void save(Genre genre) {

        genreDao.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public Genre update(Genre genre) {
        return genreDao.update(genre);
    }
}
