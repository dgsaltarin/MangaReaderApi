package com.dgsaltarin.mangareader.controller;

import com.dgsaltarin.mangareader.model.Tag;
import com.dgsaltarin.mangareader.services.TagService;
import com.dgsaltarin.mangareader.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {

    @Autowired
    private TagService _tagService;

    //GET ALL TAGS
    @RequestMapping(value = "/tags", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Tag>> getAllTags(){
        List<Tag> tags = _tagService.getAllTags();
        if (tags.isEmpty())
            return new ResponseEntity(new CustomErrorType("tags not found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Tag>>(tags, HttpStatus.OK);
    }
}
