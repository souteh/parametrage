package com.sorec.concentrateur.parametrage.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class AlertemailTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Alertemail.class);
        Alertemail alertemail1 = new Alertemail();
        alertemail1.setId(1L);
        Alertemail alertemail2 = new Alertemail();
        alertemail2.setId(alertemail1.getId());
        assertThat(alertemail1).isEqualTo(alertemail2);
        alertemail2.setId(2L);
        assertThat(alertemail1).isNotEqualTo(alertemail2);
        alertemail1.setId(null);
        assertThat(alertemail1).isNotEqualTo(alertemail2);
    }
}
