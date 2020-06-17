package com.sorec.concentrateur.parametrage.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SmtpMapperTest {

    private SmtpMapper smtpMapper;

    @BeforeEach
    public void setUp() {
        smtpMapper = new SmtpMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(smtpMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(smtpMapper.fromId(null)).isNull();
    }
}
