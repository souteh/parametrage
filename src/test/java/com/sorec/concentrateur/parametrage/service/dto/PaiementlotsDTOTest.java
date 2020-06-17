package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class PaiementlotsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaiementlotsDTO.class);
        PaiementlotsDTO paiementlotsDTO1 = new PaiementlotsDTO();
        paiementlotsDTO1.setId(1L);
        PaiementlotsDTO paiementlotsDTO2 = new PaiementlotsDTO();
        assertThat(paiementlotsDTO1).isNotEqualTo(paiementlotsDTO2);
        paiementlotsDTO2.setId(paiementlotsDTO1.getId());
        assertThat(paiementlotsDTO1).isEqualTo(paiementlotsDTO2);
        paiementlotsDTO2.setId(2L);
        assertThat(paiementlotsDTO1).isNotEqualTo(paiementlotsDTO2);
        paiementlotsDTO1.setId(null);
        assertThat(paiementlotsDTO1).isNotEqualTo(paiementlotsDTO2);
    }
}
