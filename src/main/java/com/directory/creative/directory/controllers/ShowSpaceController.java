package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.spaces.ShowSpace;
import com.directory.creative.directory.models.spaces.Space;
import com.directory.creative.directory.models.spaces.SpaceType;
import com.directory.creative.directory.repositories.ShowSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api/showspace")
public class ShowSpaceController {

    @Autowired
    private ShowSpaceRepository showSpaceRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShowSpace> createShowSpace(@RequestBody ShowSpace newShowSpace) {
        newShowSpace.setType(SpaceType.SHOW_ONLY);

        return new ResponseEntity<>(showSpaceRepository.save(newShowSpace), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Space> readAllShowSpaces() {
        return showSpaceRepository.findAllByType(SpaceType.SHOW_ONLY);
    }

    @PutMapping("/{spaceId}")
    public @ResponseBody ShowSpace updateShowSpace(@RequestBody ShowSpace updateData, @PathVariable Long spaceId) {
        ShowSpace showSpace = (ShowSpace) showSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateData.getPropertyName() != null) showSpace
                .setPropertyName(updateData.getPropertyName());
        if (updateData.getAddress() != null) showSpace
                .setAddress(updateData.getAddress());
        if (updateData.getNeighborhood() != null) showSpace
                .setNeighborhood(updateData.getNeighborhood());
        if (updateData.getListing() != null) showSpace
                .setListing(updateData.getListing());
        if (updateData.getWaitList() != null) showSpace
                .setWaitList(updateData.getWaitList());
        if (updateData.getGalleryDescription() != null) showSpace
                .setGalleryDescription(updateData.getGalleryDescription());

        return showSpaceRepository.save(showSpace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyShowSpace(@PathVariable Long id) {
        showSpaceRepository.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);

    }

}
