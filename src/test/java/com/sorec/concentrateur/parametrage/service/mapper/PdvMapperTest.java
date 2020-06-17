package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PdvMapperTest {

    private PdvMapper pdvMapper;

    @BeforeEach
    public void setUp() {
        pdvMapper = new PdvMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pdvMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pdvMapper.fromId(null)).isNull();
    }
}
