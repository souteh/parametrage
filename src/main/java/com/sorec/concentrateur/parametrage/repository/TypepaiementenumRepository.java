package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Typepaiementenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Typepaiementenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypepaiementenumRepository extends JpaRepository<Typepaiementenum, Long>, JpaSpecificationExecutor<Typepaiementenum> {
}
