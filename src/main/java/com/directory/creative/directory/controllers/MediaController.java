package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.media.Discipline;
import com.directory.creative.directory.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    List<Discipline> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> readById(@PathVariable Long id) {
        Optional<Discipline> media = repository.findById(id);

        if (media.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(media.get(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Discipline createMedia(@RequestBody Discipline newDiscipline) {
        return repository.save(newDiscipline);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> destroyMedia(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
