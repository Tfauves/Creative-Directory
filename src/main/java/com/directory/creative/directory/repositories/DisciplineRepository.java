package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.discipline.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}
