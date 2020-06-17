package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypeannulationenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeannulationenumDTO.class);
        TypeannulationenumDTO typeannulationenumDTO1 = new TypeannulationenumDTO();
        typeannulationenumDTO1.setId(1L);
        TypeannulationenumDTO typeannulationenumDTO2 = new TypeannulationenumDTO();
        assertThat(typeannulationenumDTO1).isNotEqualTo(typeannulationenumDTO2);
        typeannulationenumDTO2.setId(typeannulationenumDTO1.getId());
        assertThat(typeannulationenumDTO1).isEqualTo(typeannulationenumDTO2);
        typeannulationenumDTO2.setId(2L);
        assertThat(typeannulationenumDTO1).isNotEqualTo(typeannulationenumDTO2);
        typeannulationenumDTO1.setId(null);
        assertThat(typeannulationenumDTO1).isNotEqualTo(typeannulationenumDTO2);
    }
}
