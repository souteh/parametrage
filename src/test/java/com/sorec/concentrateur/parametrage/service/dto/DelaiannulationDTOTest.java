package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class DelaiannulationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DelaiannulationDTO.class);
        DelaiannulationDTO delaiannulationDTO1 = new DelaiannulationDTO();
        delaiannulationDTO1.setId(1L);
        DelaiannulationDTO delaiannulationDTO2 = new DelaiannulationDTO();
        assertThat(delaiannulationDTO1).isNotEqualTo(delaiannulationDTO2);
        delaiannulationDTO2.setId(delaiannulationDTO1.getId());
        assertThat(delaiannulationDTO1).isEqualTo(delaiannulationDTO2);
        delaiannulationDTO2.setId(2L);
        assertThat(delaiannulationDTO1).isNotEqualTo(delaiannulationDTO2);
        delaiannulationDTO1.setId(null);
        assertThat(delaiannulationDTO1).isNotEqualTo(delaiannulationDTO2);
    }
}
