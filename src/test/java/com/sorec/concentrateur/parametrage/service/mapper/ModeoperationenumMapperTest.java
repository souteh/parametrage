package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ModeoperationenumMapperTest {

    private ModeoperationenumMapper modeoperationenumMapper;

    @BeforeEach
    public void setUp() {
        modeoperationenumMapper = new ModeoperationenumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(modeoperationenumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(modeoperationenumMapper.fromId(null)).isNull();
    }
}
