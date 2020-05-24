package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Page;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PageDaoImplement extends AbstractSession implements PageDao {

    @Override
    public Page getPageUrl(String mangaName, int chapterNumber, int pageNumber) {
        Page page = new Page();
        page.setPageUrl(page.BASE_URL+"/"+mangaName+"/"+chapterNumber+"/"+pageNumber);
        return page;
    }
}
