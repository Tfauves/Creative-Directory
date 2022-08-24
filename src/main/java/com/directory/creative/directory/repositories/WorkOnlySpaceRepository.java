package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.spaces.WorkOnlySpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOnlySpaceRepository extends JpaRepository<WorkOnlySpace, Long> {
}
