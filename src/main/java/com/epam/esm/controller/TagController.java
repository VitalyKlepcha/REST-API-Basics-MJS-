package com.epam.esm.controller;

import com.epam.esm.dto.MyResponseBody;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagAlreadyExistException;
import com.epam.esm.exception.TagNotFoundException;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    private TagService tagService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity save(@RequestBody Tag tag) {
        try {
//            final HttpHeaders httpHeaders= new HttpHeaders();
//            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            tagService.save(tag);
            return ResponseEntity.ok("Tag saved");
        } catch (TagAlreadyExistException e) {
            return ResponseEntity.badRequest().body(new MyResponseBody(e.getMessage(),40001));
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(tagService.getAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(tagService.get(id));
        } catch (TagNotFoundException e) {
            return ResponseEntity.badRequest().body(new MyResponseBody(e.getMessage(),40000));
        }
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity delete(@PathVariable int id){
        try{
            tagService.delete(id);
            return ResponseEntity.ok("Tag deleted");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new MyResponseBody(e.getMessage(),40002));
        }
    }
}
