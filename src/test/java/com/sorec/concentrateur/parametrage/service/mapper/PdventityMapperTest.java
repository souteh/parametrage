package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PdventityMapperTest {

    private PdventityMapper pdventityMapper;

    @BeforeEach
    public void setUp() {
        pdventityMapper = new PdventityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pdventityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pdventityMapper.fromId(null)).isNull();
    }
}
