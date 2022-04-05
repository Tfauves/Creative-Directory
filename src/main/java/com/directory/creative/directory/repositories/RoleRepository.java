package com.directory.creative.directory.repositories;

import com.directory.creative.directory.models.auth.ERole;
import com.directory.creative.directory.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}