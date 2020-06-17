package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeoperationenumMapperTest {

    private TypeoperationenumMapper typeoperationenumMapper;

    @BeforeEach
    public void setUp() {
        typeoperationenumMapper = new TypeoperationenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeoperationenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeoperationenumMapper.fromId(null)).isNull();
    }
}
