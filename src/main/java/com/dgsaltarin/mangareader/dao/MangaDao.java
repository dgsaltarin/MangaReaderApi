package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Manga;

import java.util.List;

public interface MangaDao {

    List<Manga> findAllMangas();

    Manga findMangaById(int idManga);

    List<String> findAllMangasName();

    Manga findMangaByName(String name);
}
