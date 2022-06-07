package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.discipline.Media;
import com.directory.creative.directory.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    MediaRepository repository;

    @GetMapping
    public @ResponseBody
    List<Media> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Media> readById(@PathVariable Long id) {
        Optional<Media> media = repository.findById(id);

        if (media.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(media.get(), HttpStatus.OK);
    }

    @PostMapping
    public Media createMedia(@RequestBody Media newMedia) {
        return repository.save(newMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyMedia(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }



}
