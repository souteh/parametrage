package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeannulationenumMapperTest {

    private TypeannulationenumMapper typeannulationenumMapper;

    @BeforeEach
    public void setUp() {
        typeannulationenumMapper = new TypeannulationenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeannulationenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeannulationenumMapper.fromId(null)).isNull();
    }
}
