package com.app.rdv.Security.repositories;

import com.app.rdv.Security.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRole(String role);
}

