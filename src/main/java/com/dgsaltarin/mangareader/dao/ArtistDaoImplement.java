package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Artist;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArtistDaoImplement extends AbstractSession implements ArtistDao {

    @Override
    public List<Artist> findAllArtist() {
        return null;
    }

    @Override
    public Artist findArtistById(int idArtist) {
        return null;
    }

    @Override
    public Artist findArtistByName(String name) {
        return null;
    }

    @Override
    public void updateArtist(Artist artist) {

    }

    @Override
    public void saveArtist(Artist artist) {

    }

    @Override
    public void deleteArtist(int idArtist) {

    }
}
