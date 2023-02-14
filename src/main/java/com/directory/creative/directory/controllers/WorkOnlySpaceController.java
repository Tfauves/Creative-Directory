package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.spaces.Space;
import com.directory.creative.directory.models.spaces.SpaceType;
import com.directory.creative.directory.models.spaces.WorkOnlySpace;
import com.directory.creative.directory.repositories.WorkOnlySpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api/workspace")
public class WorkOnlySpaceController {

    @Autowired
    private WorkOnlySpaceRepository workOnlySpaceRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WorkOnlySpace> createWorkSpace(@RequestBody WorkOnlySpace newWorkSpace) {
        newWorkSpace.setType(SpaceType.WORK_ONLY);

        return new ResponseEntity<>(workOnlySpaceRepository.save(newWorkSpace), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Space> readAllWorkSpaces() {
        return workOnlySpaceRepository.findAll();
    }

    @PutMapping("/{spaceId}")
    public @ResponseBody WorkOnlySpace updateWorkSpace(@RequestBody WorkOnlySpace updateData, @PathVariable Long id) {
        WorkOnlySpace workOnlySpace = (WorkOnlySpace) workOnlySpaceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateData.getPropertyName() != null) workOnlySpace
                .setPropertyName(updateData.getPropertyName());

        return workOnlySpaceRepository.save(workOnlySpace);
    }
}
