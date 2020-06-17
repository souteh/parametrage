package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PaiementlotsMapperTest {

    private PaiementlotsMapper paiementlotsMapper;

    @BeforeEach
    public void setUp() {
        paiementlotsMapper = new PaiementlotsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(paiementlotsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(paiementlotsMapper.fromId(null)).isNull();
    }
}
