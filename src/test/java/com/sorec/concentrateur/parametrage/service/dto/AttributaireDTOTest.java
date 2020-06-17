package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class AttributaireDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AttributaireDTO.class);
        AttributaireDTO attributaireDTO1 = new AttributaireDTO();
        attributaireDTO1.setId(1L);
        AttributaireDTO attributaireDTO2 = new AttributaireDTO();
        assertThat(attributaireDTO1).isNotEqualTo(attributaireDTO2);
        attributaireDTO2.setId(attributaireDTO1.getId());
        assertThat(attributaireDTO1).isEqualTo(attributaireDTO2);
        attributaireDTO2.setId(2L);
        assertThat(attributaireDTO1).isNotEqualTo(attributaireDTO2);
        attributaireDTO1.setId(null);
        assertThat(attributaireDTO1).isNotEqualTo(attributaireDTO2);
    }
}
