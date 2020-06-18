package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Smtp;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Smtp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SmtpRepository extends JpaRepository<Smtp, Long>, JpaSpecificationExecutor<Smtp> {
}
