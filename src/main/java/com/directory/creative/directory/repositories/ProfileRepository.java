package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUser_id(Long id);
}
