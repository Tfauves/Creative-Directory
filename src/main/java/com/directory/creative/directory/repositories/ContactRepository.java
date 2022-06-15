package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
//    Optional<Contact> findByContact_id(Long id);
}
