package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Paiementlots;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Paiementlots entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaiementlotsRepository extends JpaRepository<Paiementlots, Long>, JpaSpecificationExecutor<Paiementlots> {
}
