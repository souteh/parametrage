package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypepdvMapperTest {

    private TypepdvMapper typepdvMapper;

    @BeforeEach
    public void setUp() {
        typepdvMapper = new TypepdvMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typepdvMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typepdvMapper.fromId(null)).isNull();
    }
}
