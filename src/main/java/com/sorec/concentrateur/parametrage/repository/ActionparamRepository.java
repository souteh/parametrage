package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Actionparam;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Actionparam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActionparamRepository extends JpaRepository<Actionparam, Long>, JpaSpecificationExecutor<Actionparam> {
}
