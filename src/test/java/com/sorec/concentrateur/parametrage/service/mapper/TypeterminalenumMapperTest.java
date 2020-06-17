package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeterminalenumMapperTest {

    private TypeterminalenumMapper typeterminalenumMapper;

    @BeforeEach
    public void setUp() {
        typeterminalenumMapper = new TypeterminalenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeterminalenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeterminalenumMapper.fromId(null)).isNull();
    }
}
