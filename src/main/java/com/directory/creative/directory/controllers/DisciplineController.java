package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.Discipline;
import com.directory.creative.directory.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/practice")
public class DisciplineController {

    @Autowired
    DisciplineRepository repository;

    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline newDiscipline) {
        return new ResponseEntity<>(repository.save(newDiscipline), HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    List<Discipline> readAll() {
        return repository.findAll();
    }
}
