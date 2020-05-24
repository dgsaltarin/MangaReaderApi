package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Page;

import java.util.List;

public interface ChapterService {

    Chapter getChapter(int idChapter);

    Page getChapterPage(int idPage);
}
