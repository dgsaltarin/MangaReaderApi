package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Artist;
import com.dgsaltarin.mangareader.services.ArtistService;
import com.dgsaltarin.mangareader.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ArtistController {

    @Autowired
    private ArtistService _artistService;

    //GET
    @RequestMapping(value = "/artist", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Artist>> getAllArtist(){
        List<Artist> artists;
        artists = _artistService.findAllArtist();
        if (artists.isEmpty())
            return new ResponseEntity(new CustomErrorType("Not artist found"), HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    //POST
    @RequestMapping(value = "/artist", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createArtist(@RequestBody Artist artist, UriComponentsBuilder uriComponentsBuilder){
        if (artist.getName().isEmpty()||artist.getName().equals(""))
            return new ResponseEntity(new CustomErrorType("Artist is required"), HttpStatus.NO_CONTENT);
        if (_artistService.findArtistByName(artist.getName())!=null)
            return new ResponseEntity(new CustomErrorType("Artist already Exist"), HttpStatus.CONFLICT);

        _artistService.saveArtist(artist);
        Artist newArtist = _artistService.findArtistByName(artist.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/artist/{id}")
        .buildAndExpand(newArtist.getIdArtist()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
}
