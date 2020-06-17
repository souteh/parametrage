package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ClientglentityMapperTest {

    private ClientglentityMapper clientglentityMapper;

    @BeforeEach
    public void setUp() {
        clientglentityMapper = new ClientglentityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(clientglentityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(clientglentityMapper.fromId(null)).isNull();
    }
}
