package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Commandesensible;
import com.sorec.concentrateur.parametrage.repository.CommandesensibleRepository;
import com.sorec.concentrateur.parametrage.service.dto.CommandesensibleDTO;
import com.sorec.concentrateur.parametrage.service.mapper.CommandesensibleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Commandesensible}.
 */
@Service
@Transactional
public class CommandesensibleService {

    private final Logger log = LoggerFactory.getLogger(CommandesensibleService.class);

    private final CommandesensibleRepository commandesensibleRepository;

    private final CommandesensibleMapper commandesensibleMapper;

    public CommandesensibleService(CommandesensibleRepository commandesensibleRepository, CommandesensibleMapper commandesensibleMapper) {
        this.commandesensibleRepository = commandesensibleRepository;
        this.commandesensibleMapper = commandesensibleMapper;
    }

    /**
     * Save a commandesensible.
     *
     * @param commandesensibleDTO the entity to save.
     * @return the persisted entity.
     */
    public CommandesensibleDTO save(CommandesensibleDTO commandesensibleDTO) {
        log.debug("Request to save Commandesensible : {}", commandesensibleDTO);
        Commandesensible commandesensible = commandesensibleMapper.toEntity(commandesensibleDTO);
        commandesensible = commandesensibleRepository.save(commandesensible);
        return commandesensibleMapper.toDto(commandesensible);
    }

    /**
     * Get all the commandesensibles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CommandesensibleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Commandesensibles");
        return commandesensibleRepository.findAll(pageable)
            .map(commandesensibleMapper::toDto);
    }


    /**
     * Get one commandesensible by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CommandesensibleDTO> findOne(Long id) {
        log.debug("Request to get Commandesensible : {}", id);
        return commandesensibleRepository.findById(id)
            .map(commandesensibleMapper::toDto);
    }

    /**
     * Delete the commandesensible by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Commandesensible : {}", id);
        commandesensibleRepository.deleteById(id);
    }
}
