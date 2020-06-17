package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypeterminalDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeterminalDTO.class);
        TypeterminalDTO typeterminalDTO1 = new TypeterminalDTO();
        typeterminalDTO1.setId(1L);
        TypeterminalDTO typeterminalDTO2 = new TypeterminalDTO();
        assertThat(typeterminalDTO1).isNotEqualTo(typeterminalDTO2);
        typeterminalDTO2.setId(typeterminalDTO1.getId());
        assertThat(typeterminalDTO1).isEqualTo(typeterminalDTO2);
        typeterminalDTO2.setId(2L);
        assertThat(typeterminalDTO1).isNotEqualTo(typeterminalDTO2);
        typeterminalDTO1.setId(null);
        assertThat(typeterminalDTO1).isNotEqualTo(typeterminalDTO2);
    }
}
