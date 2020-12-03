package com.dgsaltarin.mangareader.services.impl;

import com.dgsaltarin.mangareader.dao.PageDao;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("pageService")
@Transactional
public class PageServiceImplement implements PageService {

    @Autowired
    private PageDao _pageDao;

    @Override
    public Page getPageUrl(String mangaName, int chapterNumber, int pageNumber) {
        return _pageDao.getPageUrl(mangaName, chapterNumber, pageNumber);
    }
}
