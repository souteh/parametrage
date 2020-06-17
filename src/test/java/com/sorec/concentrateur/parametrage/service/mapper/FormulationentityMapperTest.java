package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FormulationentityMapperTest {

    private FormulationentityMapper formulationentityMapper;

    @BeforeEach
    public void setUp() {
        formulationentityMapper = new FormulationentityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(formulationentityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(formulationentityMapper.fromId(null)).isNull();
    }
}
