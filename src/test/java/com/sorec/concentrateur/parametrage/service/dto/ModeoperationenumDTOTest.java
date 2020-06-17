package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class ModeoperationenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ModeoperationenumDTO.class);
        ModeoperationenumDTO modeoperationenumDTO1 = new ModeoperationenumDTO();
        modeoperationenumDTO1.setId(1L);
        ModeoperationenumDTO modeoperationenumDTO2 = new ModeoperationenumDTO();
        assertThat(modeoperationenumDTO1).isNotEqualTo(modeoperationenumDTO2);
        modeoperationenumDTO2.setId(modeoperationenumDTO1.getId());
        assertThat(modeoperationenumDTO1).isEqualTo(modeoperationenumDTO2);
        modeoperationenumDTO2.setId(2L);
        assertThat(modeoperationenumDTO1).isNotEqualTo(modeoperationenumDTO2);
        modeoperationenumDTO1.setId(null);
        assertThat(modeoperationenumDTO1).isNotEqualTo(modeoperationenumDTO2);
    }
}
