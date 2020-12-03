package com.dgsaltarin.mangareader.dao.impl;

import com.dgsaltarin.mangareader.dao.AbstractSession;
import com.dgsaltarin.mangareader.dao.ArtistDao;
import com.dgsaltarin.mangareader.model.Artist;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArtistDaoImplement extends AbstractSession implements ArtistDao {

    @Override
    public List<Artist> findAllArtist() {
        return getSession().createQuery("from Artist").list();
    }

    @Override
    public Artist findArtistById(int idArtist) {
        return getSession().get(Artist.class, idArtist);
    }

    @Override
    public Artist findArtistByName(String name) {
        return (Artist) getSession().createQuery("from Artist where name = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public void updateArtist(Artist artist) {
        getSession().update(artist);
    }

    @Override
    public void saveArtist(Artist artist) {
        getSession().persist(artist);
    }

    @Override
    public void deleteArtist(int idArtist) {
        getSession().delete(idArtist);
    }
}
