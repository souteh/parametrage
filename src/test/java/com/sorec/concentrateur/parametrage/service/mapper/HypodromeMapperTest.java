package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HypodromeMapperTest {

    private HypodromeMapper hypodromeMapper;

    @BeforeEach
    public void setUp() {
        hypodromeMapper = new HypodromeMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(hypodromeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(hypodromeMapper.fromId(null)).isNull();
    }
}
