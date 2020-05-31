package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.dao.ChapterDao;
import com.dgsaltarin.mangareader.dao.MangaDao;
import com.dgsaltarin.mangareader.dao.PreviewDao;
import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.model.Preview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("previewService")
public class PreviewServiceImplement implements PreviewService {

    @Autowired
    private PreviewDao _previewDao;

    @Autowired
    private MangaDao _mangaDao;

    @Autowired
    private ChapterDao _chapterDao;

    @Override
    public List<Preview> getAllMangasPreview(List<Manga> mangas) {
        return _previewDao.getAllMangasPreview(mangas);
    }

    @Override
    public List<Preview> getAllChapterPreviews(int mangaId) {
        return _previewDao.getAllChapterPreviews(mangaId);
    }

    @Override
    public List<Preview> getAllPagesPreview(int idChapter) {
        return _previewDao.getAllPagesPreview(idChapter);
    }
}
