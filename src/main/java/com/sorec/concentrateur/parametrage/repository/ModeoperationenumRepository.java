package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Modeoperationenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Modeoperationenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModeoperationenumRepository extends JpaRepository<Modeoperationenum, Long>, JpaSpecificationExecutor<Modeoperationenum> {
}
