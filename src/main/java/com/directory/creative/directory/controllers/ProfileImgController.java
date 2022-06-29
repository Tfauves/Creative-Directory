package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.profile.ProfileImg;
import com.directory.creative.directory.repositories.ProfileImgRepository;
import com.directory.creative.directory.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/profImg")
public class ProfileImgController {

    @Autowired
    private ProfileImgRepository repository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public @ResponseBody
    List<ProfileImg> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody ProfileImg readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
