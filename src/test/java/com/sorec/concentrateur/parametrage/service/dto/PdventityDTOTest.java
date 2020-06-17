package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class PdventityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PdventityDTO.class);
        PdventityDTO pdventityDTO1 = new PdventityDTO();
        pdventityDTO1.setId(1L);
        PdventityDTO pdventityDTO2 = new PdventityDTO();
        assertThat(pdventityDTO1).isNotEqualTo(pdventityDTO2);
        pdventityDTO2.setId(pdventityDTO1.getId());
        assertThat(pdventityDTO1).isEqualTo(pdventityDTO2);
        pdventityDTO2.setId(2L);
        assertThat(pdventityDTO1).isNotEqualTo(pdventityDTO2);
        pdventityDTO1.setId(null);
        assertThat(pdventityDTO1).isNotEqualTo(pdventityDTO2);
    }
}
