package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class PdvDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PdvDTO.class);
        PdvDTO pdvDTO1 = new PdvDTO();
        pdvDTO1.setId(1L);
        PdvDTO pdvDTO2 = new PdvDTO();
        assertThat(pdvDTO1).isNotEqualTo(pdvDTO2);
        pdvDTO2.setId(pdvDTO1.getId());
        assertThat(pdvDTO1).isEqualTo(pdvDTO2);
        pdvDTO2.setId(2L);
        assertThat(pdvDTO1).isNotEqualTo(pdvDTO2);
        pdvDTO1.setId(null);
        assertThat(pdvDTO1).isNotEqualTo(pdvDTO2);
    }
}
