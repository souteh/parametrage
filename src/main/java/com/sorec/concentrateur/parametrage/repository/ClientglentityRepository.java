package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Clientglentity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Clientglentity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClientglentityRepository extends JpaRepository<Clientglentity, Long>, JpaSpecificationExecutor<Clientglentity> {
}
