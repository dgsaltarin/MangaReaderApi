package com.dgsaltarin.mangareader.dao;

import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.model.Preview;

import java.util.List;

public interface PreviewDao {

    List<Preview> getAllMangasPreview(List<Manga> mangas);

    /**
     * Get all previews from all chapters of an specific manga
     * @param mangaId list of chapters for made a preview
     * @return a list of previews
     */
    List<Preview> getAllChapterPreviews(int mangaId);

    /**
     * get All previews of the pages from a manga chapter
     * @param idChapter id form the chapter to generate preview
     * @return a list a previews
     */
    List<Preview> getAllPagesPreview(int idChapter);
}
