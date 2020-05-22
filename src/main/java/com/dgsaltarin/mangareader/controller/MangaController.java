package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.services.MangaService;
import com.dgsaltarin.mangareader.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class MangaController {

    @Autowired
    private MangaService _mangaService;

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
    @RequestMapping(value = "/manga/{id}", method = RequestMethod.GET, headers = "Accept-application/json")
    public ResponseEntity<Manga> getMangaById(@PathVariable("idManga") int idManga){
        Manga manga;
        if (idManga<=0)
            return new ResponseEntity(new CustomErrorType("id_manga is required"), HttpStatus.NO_CONTENT);

        manga = _mangaService.findMangaById(idManga);
        if (manga==null)
            return new ResponseEntity(new CustomErrorType("Not manga found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<Manga>(manga, HttpStatus.OK);
    }
}
