package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Pdventity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Pdventity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PdventityRepository extends JpaRepository<Pdventity, Long>, JpaSpecificationExecutor<Pdventity> {
}
