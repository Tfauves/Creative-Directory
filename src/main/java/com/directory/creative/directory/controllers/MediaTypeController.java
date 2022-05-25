package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.discipline.MediaType;
import com.directory.creative.directory.repositories.MediaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/media")
public class MediaTypeController {

    @Autowired
    MediaTypeRepository repository;

    @PostMapping
    public ResponseEntity<MediaType> createMediaType(@RequestBody MediaType newMediaType) {
        return new ResponseEntity<>(repository.save(newMediaType), HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    List<MediaType> readAllMediaTypes() {
        return repository.findAll();
    }
}
