package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.CommandesensibleService;
import com.sorec.concentrateur.parametrage.domain.Commandesensible;
import com.sorec.concentrateur.parametrage.repository.CommandesensibleRepository;
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
public class CommandesensibleServiceImpl implements CommandesensibleService {

    private final Logger log = LoggerFactory.getLogger(CommandesensibleServiceImpl.class);

    private final CommandesensibleRepository commandesensibleRepository;

    public CommandesensibleServiceImpl(CommandesensibleRepository commandesensibleRepository) {
        this.commandesensibleRepository = commandesensibleRepository;
    }

    /**
     * Save a commandesensible.
     *
     * @param commandesensible the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Commandesensible save(Commandesensible commandesensible) {
        log.debug("Request to save Commandesensible : {}", commandesensible);
        return commandesensibleRepository.save(commandesensible);
    }

    /**
     * Get all the commandesensibles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Commandesensible> findAll(Pageable pageable) {
        log.debug("Request to get all Commandesensibles");
        return commandesensibleRepository.findAll(pageable);
    }


    /**
     * Get one commandesensible by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Commandesensible> findOne(Long id) {
        log.debug("Request to get Commandesensible : {}", id);
        return commandesensibleRepository.findById(id);
    }

    /**
     * Delete the commandesensible by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Commandesensible : {}", id);
        commandesensibleRepository.deleteById(id);
    }
}
