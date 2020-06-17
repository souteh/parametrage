package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class ChoisitDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ChoisitDTO.class);
        ChoisitDTO choisitDTO1 = new ChoisitDTO();
        choisitDTO1.setId(1L);
        ChoisitDTO choisitDTO2 = new ChoisitDTO();
        assertThat(choisitDTO1).isNotEqualTo(choisitDTO2);
        choisitDTO2.setId(choisitDTO1.getId());
        assertThat(choisitDTO1).isEqualTo(choisitDTO2);
        choisitDTO2.setId(2L);
        assertThat(choisitDTO1).isNotEqualTo(choisitDTO2);
        choisitDTO1.setId(null);
        assertThat(choisitDTO1).isNotEqualTo(choisitDTO2);
    }
}
