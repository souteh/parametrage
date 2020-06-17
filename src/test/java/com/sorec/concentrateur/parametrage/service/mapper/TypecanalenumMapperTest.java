package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypecanalenumMapperTest {

    private TypecanalenumMapper typecanalenumMapper;

    @BeforeEach
    public void setUp() {
        typecanalenumMapper = new TypecanalenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typecanalenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typecanalenumMapper.fromId(null)).isNull();
    }
}
