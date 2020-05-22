package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.dao.ArtistDao;
import com.dgsaltarin.mangareader.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("artistService")
@Transactional
public class ArtistServiceImplement implements ArtistService {

    @Autowired
    private ArtistDao _artistDao;

    @Override
    public List<Artist> findAllArtist() {
        return _artistDao.findAllArtist();
    }

    @Override
    public Artist findArtistById(int idArtist) {
        return _artistDao.findArtistById(idArtist);
    }

    @Override
    public Artist findArtistByName(String name) {
        return _artistDao.findArtistByName(name);
    }

    @Override
    public void updateArtist(Artist artist) {
        _artistDao.updateArtist(artist);
    }

    @Override
    public void saveArtist(Artist artist) {
        _artistDao.saveArtist(artist);
    }

    @Override
    public void deleteArtist(int idArtist) {
        _artistDao.deleteArtist(idArtist);
    }
}
