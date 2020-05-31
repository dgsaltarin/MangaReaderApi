package com.dgsaltarin.mangareader.services;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.model.Preview;

import java.util.List;

public interface PreviewService {

    List<Preview> getAllMangasPreview(List<Manga> mangas);

    /**
     * Get all previews from all chapters of an specific manga
     * @param mangaId id of the manga for made a preview
     * @return a list of previews
     */
    List<Preview> getAllChapterPreviews(int mangaId);

    /**
     * get All previews of the pages from a manga chapter
     * @param idChapter chapter's if for preview
     * @return a list a previews
     */
    List<Preview> getAllPagesPreview(int idChapter);
}
