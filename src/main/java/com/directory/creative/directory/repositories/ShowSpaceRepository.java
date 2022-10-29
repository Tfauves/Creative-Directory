package com.directory.creative.directory.repositories;
import com.directory.creative.directory.models.spaces.ShowSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSpaceRepository extends JpaRepository<ShowSpace, Long> {

    // todo when added to an artist profile define an List<ShowSpace>findByArtist_id(Long id);
}
