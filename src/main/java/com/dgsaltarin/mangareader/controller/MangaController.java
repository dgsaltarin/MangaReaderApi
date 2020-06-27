package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Chapter;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Preview;
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
public class MangaController {

    @Autowired
    private MangaService _mangaService;

    @Autowired
    private PreviewService _previewService;

    @Autowired

    //GET ALL MANGAS
    @RequestMapping(value = "/manga", method = RequestMethod.GET)
    public ResponseEntity<List<Manga>> getAllMangas(){
        List<Manga> mangas;
        mangas = _mangaService.findAllMangas();
        if (mangas.isEmpty())
            return new ResponseEntity(new CustomErrorType("No mangas found"), HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Manga>>(mangas, HttpStatus.OK);
    }

    //GET MANDA BY ID
    @RequestMapping(value = "/manga/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Manga> getMangaById(@PathVariable("id") int idManga){
        Manga manga;
        if (idManga<=0)
            return new ResponseEntity(new CustomErrorType("id_manga is required"), HttpStatus.NO_CONTENT);

        manga = _mangaService.findMangaById(idManga);
        if (manga==null)
            return new ResponseEntity(new CustomErrorType("Not manga found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<Manga>(manga, HttpStatus.OK);
    }

    //GET RANDOM MANGA
    @RequestMapping(value = "/manga/random", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Manga> getRandomManga(){
        Manga manga = _mangaService.findRandomManga();
        return new ResponseEntity<Manga>(manga, HttpStatus.OK);
    }

    //GET ALL MANGA'S CHAPTERS
    @RequestMapping(value = "/manga/{id}/chapters", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Chapter>> getAllMangaChapters(@PathVariable("id") int idManga){
        if (idManga<=0)
            return new ResponseEntity(new CustomErrorType("idManga id required"), HttpStatus.NO_CONTENT);

        Manga manga = _mangaService.findMangaById(idManga);
        if (manga==null)
            return new ResponseEntity(new CustomErrorType("Manga not found"), HttpStatus.NOT_FOUND);

        List<Chapter> chapters = _mangaService.findAllChapter(idManga);
        return new ResponseEntity<List<Chapter>>(chapters, HttpStatus.OK);
    }

    //GET ALL MANGAS PREVIEW
    @RequestMapping(value = "/mangaPreviews", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Preview>> getAllMangasPreview(){
        List<Manga> allMangas = _mangaService.findAllMangas();
        if (allMangas.isEmpty())
            return new ResponseEntity(new CustomErrorType("no mangas found"), HttpStatus.NOT_FOUND);

        List<Preview> previews = _previewService.getAllMangasPreview(allMangas);
        return new ResponseEntity<List<Preview>>(previews, HttpStatus.OK);
    }

    //GET A MANGA'S CHAPTER PREVIEW
    @RequestMapping(value = "/manga/{id_manga}/chaptersPreview", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Preview>> getAllChapterPreview(@PathVariable("id_manga") int mangaId){
        if (mangaId<=0)
            return new ResponseEntity(new CustomErrorType("mangaId id required"), HttpStatus.NO_CONTENT);

        List<Preview> chaptersPreview = _previewService.getAllChapterPreviews(mangaId);
        if (chaptersPreview.isEmpty())
            return new ResponseEntity(new CustomErrorType("no previews found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Preview>>(chaptersPreview, HttpStatus.OK);
    }
}
