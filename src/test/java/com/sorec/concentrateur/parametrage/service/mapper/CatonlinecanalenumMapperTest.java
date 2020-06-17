package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CatonlinecanalenumMapperTest {

    private CatonlinecanalenumMapper catonlinecanalenumMapper;

    @BeforeEach
    public void setUp() {
        catonlinecanalenumMapper = new CatonlinecanalenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(catonlinecanalenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(catonlinecanalenumMapper.fromId(null)).isNull();
    }
}
