package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypeterminalenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeterminalenumDTO.class);
        TypeterminalenumDTO typeterminalenumDTO1 = new TypeterminalenumDTO();
        typeterminalenumDTO1.setId(1L);
        TypeterminalenumDTO typeterminalenumDTO2 = new TypeterminalenumDTO();
        assertThat(typeterminalenumDTO1).isNotEqualTo(typeterminalenumDTO2);
        typeterminalenumDTO2.setId(typeterminalenumDTO1.getId());
        assertThat(typeterminalenumDTO1).isEqualTo(typeterminalenumDTO2);
        typeterminalenumDTO2.setId(2L);
        assertThat(typeterminalenumDTO1).isNotEqualTo(typeterminalenumDTO2);
        typeterminalenumDTO1.setId(null);
        assertThat(typeterminalenumDTO1).isNotEqualTo(typeterminalenumDTO2);
    }
}
