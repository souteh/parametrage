package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class HypodromeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(HypodromeDTO.class);
        HypodromeDTO hypodromeDTO1 = new HypodromeDTO();
        hypodromeDTO1.setId(1L);
        HypodromeDTO hypodromeDTO2 = new HypodromeDTO();
        assertThat(hypodromeDTO1).isNotEqualTo(hypodromeDTO2);
        hypodromeDTO2.setId(hypodromeDTO1.getId());
        assertThat(hypodromeDTO1).isEqualTo(hypodromeDTO2);
        hypodromeDTO2.setId(2L);
        assertThat(hypodromeDTO1).isNotEqualTo(hypodromeDTO2);
        hypodromeDTO1.setId(null);
        assertThat(hypodromeDTO1).isNotEqualTo(hypodromeDTO2);
    }
}
