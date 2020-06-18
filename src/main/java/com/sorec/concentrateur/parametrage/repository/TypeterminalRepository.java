package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Typeterminal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Typeterminal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeterminalRepository extends JpaRepository<Typeterminal, Long>, JpaSpecificationExecutor<Typeterminal> {
}
