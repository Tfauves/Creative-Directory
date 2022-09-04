package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.media.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Discipline, Long> {



}
