package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class StatutticketenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StatutticketenumDTO.class);
        StatutticketenumDTO statutticketenumDTO1 = new StatutticketenumDTO();
        statutticketenumDTO1.setId(1L);
        StatutticketenumDTO statutticketenumDTO2 = new StatutticketenumDTO();
        assertThat(statutticketenumDTO1).isNotEqualTo(statutticketenumDTO2);
        statutticketenumDTO2.setId(statutticketenumDTO1.getId());
        assertThat(statutticketenumDTO1).isEqualTo(statutticketenumDTO2);
        statutticketenumDTO2.setId(2L);
        assertThat(statutticketenumDTO1).isNotEqualTo(statutticketenumDTO2);
        statutticketenumDTO1.setId(null);
        assertThat(statutticketenumDTO1).isNotEqualTo(statutticketenumDTO2);
    }
}
