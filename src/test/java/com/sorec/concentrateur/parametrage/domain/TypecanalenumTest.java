package com.sorec.concentrateur.parametrage.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class TypecanalenumTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Typecanalenum.class);
        Typecanalenum typecanalenum1 = new Typecanalenum();
        typecanalenum1.setId(1L);
        Typecanalenum typecanalenum2 = new Typecanalenum();
        typecanalenum2.setId(typecanalenum1.getId());
        assertThat(typecanalenum1).isEqualTo(typecanalenum2);
        typecanalenum2.setId(2L);
        assertThat(typecanalenum1).isNotEqualTo(typecanalenum2);
        typecanalenum1.setId(null);
        assertThat(typecanalenum1).isNotEqualTo(typecanalenum2);
    }
}
