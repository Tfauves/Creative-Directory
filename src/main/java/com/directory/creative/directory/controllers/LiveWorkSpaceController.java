package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.spaces.LiveWorkSpace;
import com.directory.creative.directory.models.spaces.Space;
import com.directory.creative.directory.models.spaces.SpaceType;
import com.directory.creative.directory.repositories.LiveWorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
        newLiveWorkSpace.setType(SpaceType.LIVE_WORK);
        return new ResponseEntity<>(liveWorkSpaceRepository.save(newLiveWorkSpace), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Space> readAllLiveSpace() {
        return liveWorkSpaceRepository.findAllByType(SpaceType.LIVE_WORK);
    }

    @PutMapping("/{spaceId}")
    public @ResponseBody
    LiveWorkSpace updateLiveWorkSpace(@RequestBody LiveWorkSpace updateData, @PathVariable Long spaceId) {
        LiveWorkSpace liveWorkSpace = (LiveWorkSpace) liveWorkSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateData.getPropertyName() != null) liveWorkSpace
                .setPropertyName(updateData.getPropertyName());
        if (updateData.getAddress() != null) liveWorkSpace
                .setAddress(updateData.getAddress());
        if (updateData.getNeighborhood() != null) liveWorkSpace
                .setNeighborhood(updateData.getNeighborhood());
        if (updateData.getListing() != null) liveWorkSpace
                .setListing(updateData.getListing());
        if (updateData.getWaitList() != null) liveWorkSpace
                .setWaitList(updateData.getWaitList());
        if (updateData.getBedroom() != null) liveWorkSpace
                .setBedroom(updateData.getBedroom());
        if(updateData.getBathroom() != null) liveWorkSpace
                .setBathroom(updateData.getBathroom());

        return liveWorkSpaceRepository.save(liveWorkSpace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyLiveWorkSpace(@PathVariable Long id) {
        liveWorkSpaceRepository.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);

    }

}
