package com.directory.creative.directory.controllers;

import com.directory.creative.directory.models.auth.User;
import com.directory.creative.directory.models.media.Discipline;
import com.directory.creative.directory.models.profile.Profile;
import com.directory.creative.directory.models.profile.ProfileImg;
import com.directory.creative.directory.repositories.MediaRepository;
import com.directory.creative.directory.repositories.ProfileImgRepository;
import com.directory.creative.directory.repositories.ProfileRepository;
import com.directory.creative.directory.service.UserService;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MediaRepository mediaRepository;


    @Autowired
    private ProfileImgRepository profileImgRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {
        User currentUser = userService.getCurrentUser();
        if(currentUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        newProfile.setUser(currentUser);
        return new ResponseEntity<>(repository.save(newProfile), HttpStatus.CREATED);
    }



    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody List<Profile> findAll() {
        return repository.findAll();
    }


    @GetMapping
    public Iterable<Profile> readAllProfile(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedProfileFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Profile> profiles = repository.findAll();
        session.disableFilter("deletedProfileFilter");
        return profiles;
    }


    @GetMapping("/media/{mediaId}")
    public @ResponseBody List<Profile> findAllByMedia_id(@PathVariable Long mediaId) {
        return repository.findByMedia_id(mediaId);
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

    @GetMapping("/{id}")
    public @ResponseBody Profile getById() {
        User currentUser = userService.getCurrentUser();

        if(currentUser == null) {
            return null;
        }

        return repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    // TODO: 9/4/2022 refactor to work with changes to profile this is part of issue with img 
    @PutMapping
    public @ResponseBody
    Profile updateProfile(@RequestBody Profile updateData) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            return null;

        }

        Profile profile = repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateData.getFname() != null) profile.setFname(updateData.getFname());
        if (updateData.getLname() != null) profile.setLname(updateData.getLname());
        if (updateData.getBusinessName() != null) profile.setBusinessName(updateData.getBusinessName());
        if (updateData.getMedia() != null) {
            Discipline updatedDiscipline = mediaRepository.findById(updateData.getMedia().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            profile.setMedia(updatedDiscipline);
        }

//        if (updateData.getProImg().getUrl() != null) {
//            ProfileImg newImg = updateData.getProImg();
//            profileImgRepository.save(newImg);
//            profile.setProImg(newImg);
//        }

        return repository.save(profile);

    }

    @PutMapping("/practice")
    public Profile updateMedia(@RequestBody Profile mediaUpdates) {
        User currentUser = userService.getCurrentUser();
        if(currentUser == null) {
            return null;
        }
        Profile profile = repository.findByUser_id(currentUser.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return repository.save(profile);

    }

    @PutMapping("/pic")
    public Profile updateProfilePic(@RequestBody Profile pro) {

        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return null;
        }

        Profile profile = repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!Objects.equals(pro.getProImg().getUrl(), "")) {
            ProfileImg avatar = pro.getProImg();
            avatar.setUrl(pro.getProImg().getUrl());
            profileImgRepository.save(avatar);
            profile.setProImg(avatar);

        }
        ProfileImg avatar = profile.getProImg();
        profileImgRepository.save(avatar);

        return repository.save(profile);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
