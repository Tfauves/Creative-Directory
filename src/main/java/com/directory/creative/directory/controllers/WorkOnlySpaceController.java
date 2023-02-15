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
    public @ResponseBody WorkOnlySpace updateWorkSpace(@RequestBody WorkOnlySpace updateData, @PathVariable Long spaceId) {
        WorkOnlySpace workOnlySpace = (WorkOnlySpace) workOnlySpaceRepository.findById(spaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateData.getPropertyName() != null) workOnlySpace
                .setPropertyName(updateData.getPropertyName());
        if (updateData.getAddress() != null) workOnlySpace
                .setAddress(updateData.getAddress());
        if (updateData.getNeighborhood() != null) workOnlySpace
                .setNeighborhood(updateData.getNeighborhood());
        if (updateData.getListing() != null) workOnlySpace
                .setListing(updateData.getListing());
        if (updateData.getWaitList() != null) workOnlySpace
                .setWaitList(updateData.getWaitList());
        if (updateData.getTotalArtistUnits() != null) workOnlySpace
                .setTotalArtistUnits(updateData.getTotalArtistUnits());
        if (updateData.getRentOrOwn() != null) workOnlySpace
                .setRentOrOwn(updateData.getRentOrOwn());

        return workOnlySpaceRepository.save(workOnlySpace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyWorkOnlySpace(@PathVariable Long id) {
        workOnlySpaceRepository.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);

    }
}
