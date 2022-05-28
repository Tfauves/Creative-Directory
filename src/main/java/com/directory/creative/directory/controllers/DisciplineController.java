package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.discipline.Discipline;
import com.directory.creative.directory.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    DisciplineRepository repository;

    @GetMapping
    public @ResponseBody
    List<Discipline> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> readById(@PathVariable Long id) {
        Optional<Discipline> discipline = repository.findById(id);

        if (discipline.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(discipline.get(), HttpStatus.OK);
    }



}
