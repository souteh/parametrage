package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class SmtpDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SmtpDTO.class);
        SmtpDTO smtpDTO1 = new SmtpDTO();
        smtpDTO1.setId(1L);
        SmtpDTO smtpDTO2 = new SmtpDTO();
        assertThat(smtpDTO1).isNotEqualTo(smtpDTO2);
        smtpDTO2.setId(smtpDTO1.getId());
        assertThat(smtpDTO1).isEqualTo(smtpDTO2);
        smtpDTO2.setId(2L);
        assertThat(smtpDTO1).isNotEqualTo(smtpDTO2);
        smtpDTO1.setId(null);
        assertThat(smtpDTO1).isNotEqualTo(smtpDTO2);
    }
}
