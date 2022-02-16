package com.epam.esm.controller;

import com.epam.esm.dao.TagDAO;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.TestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    public TagController(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    private TagDAO tagDAO;

    @PostMapping(value = "/test",consumes = "application/json")
    public ResponseEntity test(@RequestBody Tag tag){
        try {
//            final HttpHeaders httpHeaders= new HttpHeaders();
//            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            tagDAO.save(tag);
            return ResponseEntity.ok("Tag saved");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Tag isn't saved");
        }
    }

    @GetMapping(value = "/test",produces = "application/json")
    public ResponseEntity test2(){
        return ResponseEntity.ok(new Tag(1,"1"));
    }
}
