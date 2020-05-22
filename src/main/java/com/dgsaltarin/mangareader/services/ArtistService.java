package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtist();

    Artist findArtistById(int idArtist);

    Artist findArtistByName(String name);

    void updateArtist(Artist artist);

    void saveArtist(Artist artist);

    void deleteArtist(int idArtist);
}
