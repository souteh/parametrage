package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypeoperationenumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeoperationenumDTO.class);
        TypeoperationenumDTO typeoperationenumDTO1 = new TypeoperationenumDTO();
        typeoperationenumDTO1.setId(1L);
        TypeoperationenumDTO typeoperationenumDTO2 = new TypeoperationenumDTO();
        assertThat(typeoperationenumDTO1).isNotEqualTo(typeoperationenumDTO2);
        typeoperationenumDTO2.setId(typeoperationenumDTO1.getId());
        assertThat(typeoperationenumDTO1).isEqualTo(typeoperationenumDTO2);
        typeoperationenumDTO2.setId(2L);
        assertThat(typeoperationenumDTO1).isNotEqualTo(typeoperationenumDTO2);
        typeoperationenumDTO1.setId(null);
        assertThat(typeoperationenumDTO1).isNotEqualTo(typeoperationenumDTO2);
    }
}
