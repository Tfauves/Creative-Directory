package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.spaces.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SpaceRepository extends CrudRepository<Space, Long> {
}
