package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.dao.ChapterDao;
import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("chapterService")
@Transactional
public class ChapterServiceImplement implements ChapterService {

    @Autowired
    private ChapterDao _chapterDao;

    @Override
    public Chapter getChapter(int idChapter) {
        return _chapterDao.getChapter(idChapter);
    }

    @Override
    public Page getChapterPage(int idPage) {
        return null;
    }
}
