package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DelaiannulationMapperTest {

    private DelaiannulationMapper delaiannulationMapper;

    @BeforeEach
    public void setUp() {
        delaiannulationMapper = new DelaiannulationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(delaiannulationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(delaiannulationMapper.fromId(null)).isNull();
    }
}
