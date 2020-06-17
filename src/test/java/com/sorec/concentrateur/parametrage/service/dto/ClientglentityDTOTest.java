package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class ClientglentityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClientglentityDTO.class);
        ClientglentityDTO clientglentityDTO1 = new ClientglentityDTO();
        clientglentityDTO1.setId(1L);
        ClientglentityDTO clientglentityDTO2 = new ClientglentityDTO();
        assertThat(clientglentityDTO1).isNotEqualTo(clientglentityDTO2);
        clientglentityDTO2.setId(clientglentityDTO1.getId());
        assertThat(clientglentityDTO1).isEqualTo(clientglentityDTO2);
        clientglentityDTO2.setId(2L);
        assertThat(clientglentityDTO1).isNotEqualTo(clientglentityDTO2);
        clientglentityDTO1.setId(null);
        assertThat(clientglentityDTO1).isNotEqualTo(clientglentityDTO2);
    }
}
