package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Tfj;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Tfj entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TfjRepository extends JpaRepository<Tfj, Long>, JpaSpecificationExecutor<Tfj> {
}
