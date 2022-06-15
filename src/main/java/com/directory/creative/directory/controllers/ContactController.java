package com.directory.creative.directory.controllers;


import com.directory.creative.directory.models.contact.Contact;
import com.directory.creative.directory.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    ContactRepository repository;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact newContact) {
        return new ResponseEntity<>(repository.save(newContact), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Contact> readAll() {
        return repository.findAll();
    }
}
