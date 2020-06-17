package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AttributaireMapperTest {

    private AttributaireMapper attributaireMapper;

    @BeforeEach
    public void setUp() {
        attributaireMapper = new AttributaireMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(attributaireMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(attributaireMapper.fromId(null)).isNull();
    }
}
