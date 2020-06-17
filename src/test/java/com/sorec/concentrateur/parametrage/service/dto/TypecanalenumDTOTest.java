package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypecanalenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypecanalenumDTO.class);
        TypecanalenumDTO typecanalenumDTO1 = new TypecanalenumDTO();
        typecanalenumDTO1.setId(1L);
        TypecanalenumDTO typecanalenumDTO2 = new TypecanalenumDTO();
        assertThat(typecanalenumDTO1).isNotEqualTo(typecanalenumDTO2);
        typecanalenumDTO2.setId(typecanalenumDTO1.getId());
        assertThat(typecanalenumDTO1).isEqualTo(typecanalenumDTO2);
        typecanalenumDTO2.setId(2L);
        assertThat(typecanalenumDTO1).isNotEqualTo(typecanalenumDTO2);
        typecanalenumDTO1.setId(null);
        assertThat(typecanalenumDTO1).isNotEqualTo(typecanalenumDTO2);
    }
}
