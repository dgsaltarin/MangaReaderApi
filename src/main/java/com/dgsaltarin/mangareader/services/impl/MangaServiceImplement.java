package com.dgsaltarin.mangareader.services.impl;

import com.dgsaltarin.mangareader.dao.MangaDao;
import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("mangaService")
@Transactional
public class MangaServiceImplement implements MangaService {

    @Autowired
    private MangaDao _mangaDao;

    @Override
    public List<Manga> findAllMangas() {
        return _mangaDao.findAllMangas();
    }

    @Override
    public Manga findMangaById(int idManga) {
        return _mangaDao.findMangaById(idManga);
    }

    @Override
    public List<String> findAllMangasName() {
        return _mangaDao.findAllMangasName();
    }

    @Override
    public Manga findMangaByName(String name) {
        return _mangaDao.findMangaByName(name);
    }

    @Override
    public Manga findRandomManga() {
        return _mangaDao.findRandomManga();
    }

    @Override
    public List<Chapter> findAllChapter(int idManga) {
        return _mangaDao.findAllChapter(idManga);
    }

    @Override
    public Chapter getChapter(int idChapter) {
        return _mangaDao.getChapter(idChapter);
    }
}
