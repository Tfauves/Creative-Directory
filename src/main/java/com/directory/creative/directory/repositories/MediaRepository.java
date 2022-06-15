package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.media.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
