package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeterminalMapperTest {

    private TypeterminalMapper typeterminalMapper;

    @BeforeEach
    public void setUp() {
        typeterminalMapper = new TypeterminalMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeterminalMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeterminalMapper.fromId(null)).isNull();
    }
}
