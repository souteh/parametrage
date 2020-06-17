package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class I18nTextTranslationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(I18nTextTranslationDTO.class);
        I18nTextTranslationDTO i18nTextTranslationDTO1 = new I18nTextTranslationDTO();
        i18nTextTranslationDTO1.setId(1L);
        I18nTextTranslationDTO i18nTextTranslationDTO2 = new I18nTextTranslationDTO();
        assertThat(i18nTextTranslationDTO1).isNotEqualTo(i18nTextTranslationDTO2);
        i18nTextTranslationDTO2.setId(i18nTextTranslationDTO1.getId());
        assertThat(i18nTextTranslationDTO1).isEqualTo(i18nTextTranslationDTO2);
        i18nTextTranslationDTO2.setId(2L);
        assertThat(i18nTextTranslationDTO1).isNotEqualTo(i18nTextTranslationDTO2);
        i18nTextTranslationDTO1.setId(null);
        assertThat(i18nTextTranslationDTO1).isNotEqualTo(i18nTextTranslationDTO2);
    }
}
