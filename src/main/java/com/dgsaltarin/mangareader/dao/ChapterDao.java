package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Chapter;

import java.util.List;

public interface ChapterDao {

    List<Chapter> getAllChapterFromManga(int idManga);

    Chapter getChapter(int idChapter);
}
