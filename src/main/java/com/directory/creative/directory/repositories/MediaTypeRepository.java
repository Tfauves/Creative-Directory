package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.discipline.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {

}
