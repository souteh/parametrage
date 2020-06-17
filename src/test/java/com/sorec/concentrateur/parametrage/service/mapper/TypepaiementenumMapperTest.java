package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypepaiementenumMapperTest {

    private TypepaiementenumMapper typepaiementenumMapper;

    @BeforeEach
    public void setUp() {
        typepaiementenumMapper = new TypepaiementenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typepaiementenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typepaiementenumMapper.fromId(null)).isNull();
    }
}
