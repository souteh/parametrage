package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class AlertemailDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AlertemailDTO.class);
        AlertemailDTO alertemailDTO1 = new AlertemailDTO();
        alertemailDTO1.setId(1L);
        AlertemailDTO alertemailDTO2 = new AlertemailDTO();
        assertThat(alertemailDTO1).isNotEqualTo(alertemailDTO2);
        alertemailDTO2.setId(alertemailDTO1.getId());
        assertThat(alertemailDTO1).isEqualTo(alertemailDTO2);
        alertemailDTO2.setId(2L);
        assertThat(alertemailDTO1).isNotEqualTo(alertemailDTO2);
        alertemailDTO1.setId(null);
        assertThat(alertemailDTO1).isNotEqualTo(alertemailDTO2);
    }
}
