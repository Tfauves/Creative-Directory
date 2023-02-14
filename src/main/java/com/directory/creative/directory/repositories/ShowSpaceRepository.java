package com.directory.creative.directory.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface ShowSpaceRepository extends SpaceRepository {

    // todo when added to an artist profile define an List<ShowSpace>findByArtist_id(Long id);
}
