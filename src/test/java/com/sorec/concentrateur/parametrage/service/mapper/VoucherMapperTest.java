package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VoucherMapperTest {

    private VoucherMapper voucherMapper;

    @BeforeEach
    public void setUp() {
        voucherMapper = new VoucherMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(voucherMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(voucherMapper.fromId(null)).isNull();
    }
}
