package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.spaces.Space;
import com.directory.creative.directory.models.spaces.SpaceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;

@NoRepositoryBean
public interface SpaceRepository extends CrudRepository<Space, Long> {
    List<Space> findAllByType(SpaceType type);

}
