package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypepdvDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypepdvDTO.class);
        TypepdvDTO typepdvDTO1 = new TypepdvDTO();
        typepdvDTO1.setId(1L);
        TypepdvDTO typepdvDTO2 = new TypepdvDTO();
        assertThat(typepdvDTO1).isNotEqualTo(typepdvDTO2);
        typepdvDTO2.setId(typepdvDTO1.getId());
        assertThat(typepdvDTO1).isEqualTo(typepdvDTO2);
        typepdvDTO2.setId(2L);
        assertThat(typepdvDTO1).isNotEqualTo(typepdvDTO2);
        typepdvDTO1.setId(null);
        assertThat(typepdvDTO1).isNotEqualTo(typepdvDTO2);
    }
}
