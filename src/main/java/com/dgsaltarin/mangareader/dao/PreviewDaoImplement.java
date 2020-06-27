package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.model.Preview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PreviewDaoImplement extends AbstractSession implements PreviewDao {
    private final String LINK = "http://localhost:8080/v1/";

    @Autowired
    private MangaDao _mangaDao;

    @Autowired
    private PageDao _pageDao;

    @Autowired
    private ChapterDao _chapterDao;

    @Override
    public List<Preview> getAllMangasPreview(List<Manga> mangas) {
        List<Preview> previews = new ArrayList<>();
        for (Manga manga:mangas){
            Preview preview = new Preview(manga.getName(), manga.getCover(), manga.getIdManga(),
                    LINK + manga.getIdManga());
            previews.add(preview);
        }

        return previews;
    }

    @Override
    public List<Preview> getAllChapterPreviews(int mangaId) {
        List<Chapter> chapters = _mangaDao.findAllChapter(mangaId);
        List<Preview> previews = new ArrayList<>();
        for (Chapter chapter:chapters){
            Page firstPage = _pageDao.getPageUrl(chapter.getManga().getName(), chapter.getChapterNumber(),1);
            Preview preview = new Preview(String.valueOf(chapter.getChapterNumber()),
                    firstPage.getPageUrl(),
                    chapter.getIdChapter(),
                    LINK + chapter.getChapterNumber());
            previews.add(preview);
        }

        return previews;
    }

    @Override
    public List<Preview> getAllPagesPreview(int idChapter) {
        Chapter chapter = _chapterDao.getChapter(idChapter);
        List<Preview> previews = new ArrayList<>();
        for (int i=1; i<chapter.getPages()+1;i++){
            Page pageUrl = _pageDao.getPageUrl(chapter.getManga().getName(), chapter.getChapterNumber(), i);
            Preview preview = new Preview(String.valueOf(i),
                    pageUrl.getPageUrl(),
                    i,
                    LINK + chapter.getManga().getName() +"/" +chapter.getIdChapter()+"/"
                    +i);
            previews.add(preview);
        }

        return previews;
    }
}
