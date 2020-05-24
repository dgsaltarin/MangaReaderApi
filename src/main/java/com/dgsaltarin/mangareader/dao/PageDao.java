package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Page;

public interface PageDao {

    Page getPageUrl(String mangaName, int chapterNumber, int pageNumber);
}
