package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class I18nTextTranslationMapperTest {

    private I18nTextTranslationMapper i18nTextTranslationMapper;

    @BeforeEach
    public void setUp() {
        i18nTextTranslationMapper = new I18nTextTranslationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(i18nTextTranslationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(i18nTextTranslationMapper.fromId(null)).isNull();
    }
}
