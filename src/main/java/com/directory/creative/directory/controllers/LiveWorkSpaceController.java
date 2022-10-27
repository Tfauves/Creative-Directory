package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.spaces.LiveWorkSpace;
import com.directory.creative.directory.repositories.LiveWorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/livespace")
public class LiveWorkSpaceController {

    @Autowired
    private LiveWorkSpaceRepository liveWorkSpaceRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LiveWorkSpace> createLiveSpace(@RequestBody LiveWorkSpace newLiveWorkSpace) {
        return new ResponseEntity<>(liveWorkSpaceRepository.save(newLiveWorkSpace), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LiveWorkSpace> readAllLiveSpace() {
        return liveWorkSpaceRepository.findAll();
    }

}
