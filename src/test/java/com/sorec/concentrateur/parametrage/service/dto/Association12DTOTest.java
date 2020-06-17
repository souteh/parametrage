package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class Association12DTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Association12DTO.class);
        Association12DTO association12DTO1 = new Association12DTO();
        association12DTO1.setId(1L);
        Association12DTO association12DTO2 = new Association12DTO();
        assertThat(association12DTO1).isNotEqualTo(association12DTO2);
        association12DTO2.setId(association12DTO1.getId());
        assertThat(association12DTO1).isEqualTo(association12DTO2);
        association12DTO2.setId(2L);
        assertThat(association12DTO1).isNotEqualTo(association12DTO2);
        association12DTO1.setId(null);
        assertThat(association12DTO1).isNotEqualTo(association12DTO2);
    }
}
