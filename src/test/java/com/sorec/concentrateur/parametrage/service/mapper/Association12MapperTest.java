package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Association12MapperTest {

    private Association12Mapper association12Mapper;

    @BeforeEach
    public void setUp() {
        association12Mapper = new Association12MapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(association12Mapper.fromId(id).getId()).isEqualTo(id);
        assertThat(association12Mapper.fromId(null)).isNull();
    }
}
