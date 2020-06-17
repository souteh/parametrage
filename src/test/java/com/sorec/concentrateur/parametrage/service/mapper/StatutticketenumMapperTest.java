package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StatutticketenumMapperTest {

    private StatutticketenumMapper statutticketenumMapper;

    @BeforeEach
    public void setUp() {
        statutticketenumMapper = new StatutticketenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(statutticketenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(statutticketenumMapper.fromId(null)).isNull();
    }
}
