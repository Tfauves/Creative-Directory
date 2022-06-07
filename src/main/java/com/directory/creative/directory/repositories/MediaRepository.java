package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.discipline.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {

}