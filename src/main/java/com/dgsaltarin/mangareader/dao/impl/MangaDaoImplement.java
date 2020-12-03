package com.dgsaltarin.mangareader.dao.impl;

import com.dgsaltarin.mangareader.dao.AbstractSession;
import com.dgsaltarin.mangareader.dao.MangaDao;
import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Repository
@Transactional
public class MangaDaoImplement extends AbstractSession implements MangaDao {

    @Override
    public List<Manga> findAllMangas() {
        return getSession().createQuery("from Manga").list();
    }

    @Override
    public Manga findMangaById(int idManga) {
        Manga manga = getSession().get(Manga.class, idManga);
        Hibernate.initialize(manga.getTags());
        return manga;
    }

    @Override
    public List<String> findAllMangasName() {
        return getSession().createQuery("select name from Manga").list();
    }

    @Override
    public Manga findMangaByName(String name) {
        return (Manga) getSession().createQuery("from Manga  where name = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public Manga findRandomManga() {
        List<Manga> mangaList = getSession().createQuery("from Manga").list();
        Random random = new Random();
        return mangaList.get(random.nextInt(mangaList.size()));
    }

    @Override
    public List<Chapter> findAllChapter(int idManga) {
        return getSession().createQuery("from Chapter where manga.idManga = :idManga")
                .setParameter("idManga", idManga).list();
    }

    @Override
    public Chapter getChapter(int idChapter) {
        return getSession().get(Chapter.class, idChapter);
    }
}
