package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getAllTags();

    List<Manga> getAllMangasByTag(int idTag);

    Tag getTagById(int idTag);

    Tag getTagByName(String name);
}
