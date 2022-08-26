package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.spaces.ShowSpace;
import com.directory.creative.directory.repositories.ShowSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/showspace")
public class ShowSpaceController {

    @Autowired
    private ShowSpaceRepository showSpaceRepository;

    @PostMapping

    public ResponseEntity<ShowSpace> createShowSpace(@RequestBody ShowSpace newShowSpace) {

        return new ResponseEntity<>(showSpaceRepository.save(newShowSpace), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ShowSpace> readAllShowSpaces() {
        return showSpaceRepository.findAll();
    }


}
