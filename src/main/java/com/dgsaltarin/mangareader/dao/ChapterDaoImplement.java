package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Page;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ChapterDaoImplement extends AbstractSession implements ChapterDao{

    @Override
    public Chapter getChapter(int idChapter) {
        return getSession().get(Chapter.class, idChapter);
    }

    @Override
    public Page getChapterPage(int idPage) {
        return null;
    }
}
