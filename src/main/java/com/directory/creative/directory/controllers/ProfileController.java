package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.auth.User;
import com.directory.creative.directory.models.profile.Profile;
import com.directory.creative.directory.repositories.ProfileRepository;
import com.directory.creative.directory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    ProfileRepository repository;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        newProfile.setUser(currentUser);
        return new ResponseEntity<>(repository.save(newProfile), HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody
    List<Profile> readAllProfile() {
        return repository.findAll();
    }

    @GetMapping("/self")
    public @ResponseBody
    Profile readProfile() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return null;
        }

        return repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public @ResponseBody
    Profile updateProfile(@RequestBody Profile updateData) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return null;

        }
        Profile profile = repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getFname() != null) profile.setFname(updateData.getFname());
        if (updateData.getLname() != null) profile.setLname(updateData.getLname());
        if (updateData.getDiscipline() != null) profile.setDiscipline(updateData.getDiscipline());
        if (updateData.getPhone() != null) profile.setPhone(updateData.getPhone());
        if (updateData.getState() != null) profile.setState(updateData.getState());
        if (updateData.getCity() != null) profile.setCity(updateData.getCity());

        return repository.save(profile);

    }
}
