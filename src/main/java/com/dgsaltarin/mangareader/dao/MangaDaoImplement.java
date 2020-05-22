package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Manga;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MangaDaoImplement extends AbstractSession implements MangaDao {

    @Override
    public List<Manga> findAllMangas() {
        return getSession().createQuery("from Manga").list();
    }

    @Override
    public Manga findMangaById(int idManga) {
        return getSession().get(Manga.class, idManga);
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
}
