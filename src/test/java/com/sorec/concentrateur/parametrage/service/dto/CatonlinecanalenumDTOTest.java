package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class CatonlinecanalenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CatonlinecanalenumDTO.class);
        CatonlinecanalenumDTO catonlinecanalenumDTO1 = new CatonlinecanalenumDTO();
        catonlinecanalenumDTO1.setId(1L);
        CatonlinecanalenumDTO catonlinecanalenumDTO2 = new CatonlinecanalenumDTO();
        assertThat(catonlinecanalenumDTO1).isNotEqualTo(catonlinecanalenumDTO2);
        catonlinecanalenumDTO2.setId(catonlinecanalenumDTO1.getId());
        assertThat(catonlinecanalenumDTO1).isEqualTo(catonlinecanalenumDTO2);
        catonlinecanalenumDTO2.setId(2L);
        assertThat(catonlinecanalenumDTO1).isNotEqualTo(catonlinecanalenumDTO2);
        catonlinecanalenumDTO1.setId(null);
        assertThat(catonlinecanalenumDTO1).isNotEqualTo(catonlinecanalenumDTO2);
    }
}
