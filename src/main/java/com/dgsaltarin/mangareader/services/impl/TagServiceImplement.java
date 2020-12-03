package com.dgsaltarin.mangareader.services.impl;

import com.dgsaltarin.mangareader.dao.TagDao;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Tag;
import com.dgsaltarin.mangareader.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImplement implements TagService {

    @Autowired
    private TagDao _tagDao;

    @Override
    public List<Tag> getAllTags() {
        return _tagDao.getAllTags();
    }

    @Override
    public List<Manga> getAllMangasByTag(int idTag) {
        return _tagDao.getAllMangasByTag(idTag);
    }

    @Override
    public Tag getTagById(int idTag) {
        return _tagDao.getTagById(idTag);
    }

    @Override
    public Tag getTagByName(String name) {
        return _tagDao.getTagByName(name);
    }
}
