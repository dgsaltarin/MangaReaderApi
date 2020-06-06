package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Page;
import com.dgsaltarin.mangareader.services.ChapterService;
import com.dgsaltarin.mangareader.services.MangaService;
import com.dgsaltarin.mangareader.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("v1")
@CrossOrigin(origins = {"http://localhost:4200", "https://dgmanga-572c3.web.app"})
public class PageController {

    @Autowired
    private ChapterService _chapterService;

    @Autowired
    private MangaService _mangaService;

    @Autowired
    private PageService _pageService;

    //GET PAGE
    @RequestMapping(value = "/{id_manga}/{chapter_numb}/{page_numb}", method = RequestMethod.GET,
    headers = "Accept=application/json")
    public ResponseEntity<Page> getChapterPage(@PathVariable("id_manga") int idManga,
                                               @PathVariable("chapter_numb") int chapterNumber,
                                               @PathVariable("page_numb") int pageNumber){
        Manga manga = _mangaService.findMangaById(idManga);
        Page page = _pageService.getPageUrl(manga.getName(), chapterNumber, pageNumber);
        return new ResponseEntity<Page>(page, HttpStatus.OK);
    }
}
