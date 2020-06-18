package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Alertemail;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Alertemail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AlertemailRepository extends JpaRepository<Alertemail, Long>, JpaSpecificationExecutor<Alertemail> {
}
