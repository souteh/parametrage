package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Attributaire;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Attributaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributaireRepository extends JpaRepository<Attributaire, Long>, JpaSpecificationExecutor<Attributaire> {
}
