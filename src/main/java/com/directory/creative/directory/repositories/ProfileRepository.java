package com.directory.creative.directory.repositories;


import com.directory.creative.directory.models.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUser_id(Long id);

    @Query(value = "SELECT * FROM profile WHERE media_id = ?1", nativeQuery = true)
    List<Profile> findByMedia_id(Long id);



}
