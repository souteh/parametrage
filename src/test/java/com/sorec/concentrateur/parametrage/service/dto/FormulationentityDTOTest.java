package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class FormulationentityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FormulationentityDTO.class);
        FormulationentityDTO formulationentityDTO1 = new FormulationentityDTO();
        formulationentityDTO1.setId(1L);
        FormulationentityDTO formulationentityDTO2 = new FormulationentityDTO();
        assertThat(formulationentityDTO1).isNotEqualTo(formulationentityDTO2);
        formulationentityDTO2.setId(formulationentityDTO1.getId());
        assertThat(formulationentityDTO1).isEqualTo(formulationentityDTO2);
        formulationentityDTO2.setId(2L);
        assertThat(formulationentityDTO1).isNotEqualTo(formulationentityDTO2);
        formulationentityDTO1.setId(null);
        assertThat(formulationentityDTO1).isNotEqualTo(formulationentityDTO2);
    }
}
