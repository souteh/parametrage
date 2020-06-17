package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Commandesensible;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Commandesensible entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommandesensibleRepository extends JpaRepository<Commandesensible, Long>, JpaSpecificationExecutor<Commandesensible> {
}
