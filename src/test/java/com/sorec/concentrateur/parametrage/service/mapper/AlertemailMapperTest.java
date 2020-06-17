package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertemailMapperTest {

    private AlertemailMapper alertemailMapper;

    @BeforeEach
    public void setUp() {
        alertemailMapper = new AlertemailMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(alertemailMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(alertemailMapper.fromId(null)).isNull();
    }
}
