//package com.directory.creative.directory.controllers;
//
//import com.directory.creative.directory.models.spaces.WorkOnlySpace;
//import com.directory.creative.directory.repositories.WorkOnlySpaceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/workspace")
//public class WorkOnlySpaceController {
//
//    @Autowired
//    private WorkOnlySpaceRepository workOnlySpaceRepository;
//
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<WorkOnlySpace> createWorkSpace(@RequestBody WorkOnlySpace newWorkSpace) {
//        return new ResponseEntity<>(workOnlySpaceRepository.save(newWorkSpace), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public List<WorkOnlySpace> readAllWorkSpaces() {
//        return workOnlySpaceRepository.findAll();
//    }
//}
