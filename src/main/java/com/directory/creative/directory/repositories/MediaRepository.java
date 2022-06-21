package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.media.Media;
import com.directory.creative.directory.models.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {



}
