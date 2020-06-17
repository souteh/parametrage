package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ChoisitMapperTest {

    private ChoisitMapper choisitMapper;

    @BeforeEach
    public void setUp() {
        choisitMapper = new ChoisitMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(choisitMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(choisitMapper.fromId(null)).isNull();
    }
}
