package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.model.Page;

public interface PageService {

    Page getPageUrl(String mangaName, int chapterNumber, int pageNumber);
}
