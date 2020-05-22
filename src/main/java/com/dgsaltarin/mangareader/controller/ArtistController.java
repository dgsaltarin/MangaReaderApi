package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Artist;
import com.dgsaltarin.mangareader.services.ArtistService;
import com.dgsaltarin.mangareader.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ArtistController {

    @Autowired
    private ArtistService _artistService;

    //GET
    @RequestMapping(value = "/artist", method = RequestMethod.GET, headers = "Accept-application-json")
    public ResponseEntity<List<Artist>> getAllArtist(){
        List<Artist> artists;
        artists = _artistService.findAllArtist();
        if (artists.isEmpty())
            return new ResponseEntity(new CustomErrorType("Not artist found"), HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }
}
