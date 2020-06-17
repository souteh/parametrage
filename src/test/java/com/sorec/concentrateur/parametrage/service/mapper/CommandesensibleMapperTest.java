package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CommandesensibleMapperTest {

    private CommandesensibleMapper commandesensibleMapper;

    @BeforeEach
    public void setUp() {
        commandesensibleMapper = new CommandesensibleMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(commandesensibleMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(commandesensibleMapper.fromId(null)).isNull();
    }
}
