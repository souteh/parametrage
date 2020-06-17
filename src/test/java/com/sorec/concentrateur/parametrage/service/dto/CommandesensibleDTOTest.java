package com.sorec.concentrateur.parametrage.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sorec.concentrateur.parametrage.web.rest.TestUtil;

public class CommandesensibleDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CommandesensibleDTO.class);
        CommandesensibleDTO commandesensibleDTO1 = new CommandesensibleDTO();
        commandesensibleDTO1.setId(1L);
        CommandesensibleDTO commandesensibleDTO2 = new CommandesensibleDTO();
        assertThat(commandesensibleDTO1).isNotEqualTo(commandesensibleDTO2);
        commandesensibleDTO2.setId(commandesensibleDTO1.getId());
        assertThat(commandesensibleDTO1).isEqualTo(commandesensibleDTO2);
        commandesensibleDTO2.setId(2L);
        assertThat(commandesensibleDTO1).isNotEqualTo(commandesensibleDTO2);
        commandesensibleDTO1.setId(null);
        assertThat(commandesensibleDTO1).isNotEqualTo(commandesensibleDTO2);
    }
}
