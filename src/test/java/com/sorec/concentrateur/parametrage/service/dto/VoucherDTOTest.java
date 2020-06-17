package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class VoucherDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VoucherDTO.class);
        VoucherDTO voucherDTO1 = new VoucherDTO();
        voucherDTO1.setId(1L);
        VoucherDTO voucherDTO2 = new VoucherDTO();
        assertThat(voucherDTO1).isNotEqualTo(voucherDTO2);
        voucherDTO2.setId(voucherDTO1.getId());
        assertThat(voucherDTO1).isEqualTo(voucherDTO2);
        voucherDTO2.setId(2L);
        assertThat(voucherDTO1).isNotEqualTo(voucherDTO2);
        voucherDTO1.setId(null);
        assertThat(voucherDTO1).isNotEqualTo(voucherDTO2);
    }
}
