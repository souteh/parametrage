package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.I18nTextTranslation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the I18nTextTranslation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface I18nTextTranslationRepository extends JpaRepository<I18nTextTranslation, Long>, JpaSpecificationExecutor<I18nTextTranslation> {
}
