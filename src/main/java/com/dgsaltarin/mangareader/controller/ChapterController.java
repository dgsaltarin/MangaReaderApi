package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Preview;
import com.dgsaltarin.mangareader.services.ChapterService;
import com.dgsaltarin.mangareader.services.MangaService;
import com.dgsaltarin.mangareader.services.PreviewService;
import com.dgsaltarin.mangareader.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/v1")
@CrossOrigin(origins = {"http://localhost:4200", "https://dgmanga-572c3.web.app"})
public class ChapterController {

    @Autowired
    private ChapterService _chapterService;

    @Autowired
    private MangaService _mangaService;

    @Autowired
    private PreviewService _previewService;

    //GET CHAPTER BY ID
    @RequestMapping(value = "/manga/{id_manga}/{id_chapter}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<Chapter> getMangaChapter(@PathVariable("id_manga") int idManga,
                                                   @PathVariable("id_chapter") int idChapter) {
        if (idManga<=0||idChapter<=0)
            return new ResponseEntity(new CustomErrorType("idManga and idChapter are required"), HttpStatus.NO_CONTENT);

        Manga manga = _mangaService.findMangaById(idManga);
        if (manga==null)
            return new ResponseEntity(new CustomErrorType("manga not found"), HttpStatus.NOT_FOUND);

        Chapter chapterToReturn = _chapterService.getChapter(idChapter);
        return new ResponseEntity<Chapter>(chapterToReturn, HttpStatus.OK);
    }

    //GET CHAPTER PREVIEWS
    @RequestMapping(value = "/manga/{id_chapter}/preview", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Preview>> getChapterPreview(@PathVariable("id_chapter") int idChapter){
        if (idChapter<=0)
            return new ResponseEntity(new CustomErrorType("id_chapter is required"), HttpStatus.NO_CONTENT);

        List<Preview> previews = _previewService.getAllPagesPreview(idChapter);
        if (previews.isEmpty())
            return new ResponseEntity(new CustomErrorType("previews not found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Preview>>(previews, HttpStatus.OK);
  }
}
