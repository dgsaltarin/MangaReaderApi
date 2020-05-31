package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Page;

import java.util.List;

public interface ChapterDao {

    Chapter getChapter(int idChapter);

    Page getChapterPage(int idPage);

    List<Page> getAllPages(int idChapter);

    String getChapterFirstPage(int idChapter);
}
