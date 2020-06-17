package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Clientglentity;
import com.sorec.concentrateur.parametrage.repository.ClientglentityRepository;
import com.sorec.concentrateur.parametrage.service.dto.ClientglentityDTO;
import com.sorec.concentrateur.parametrage.service.mapper.ClientglentityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Clientglentity}.
 */
@Service
@Transactional
public class ClientglentityService {

    private final Logger log = LoggerFactory.getLogger(ClientglentityService.class);

    private final ClientglentityRepository clientglentityRepository;

    private final ClientglentityMapper clientglentityMapper;

    public ClientglentityService(ClientglentityRepository clientglentityRepository, ClientglentityMapper clientglentityMapper) {
        this.clientglentityRepository = clientglentityRepository;
        this.clientglentityMapper = clientglentityMapper;
    }

    /**
     * Save a clientglentity.
     *
     * @param clientglentityDTO the entity to save.
     * @return the persisted entity.
     */
    public ClientglentityDTO save(ClientglentityDTO clientglentityDTO) {
        log.debug("Request to save Clientglentity : {}", clientglentityDTO);
        Clientglentity clientglentity = clientglentityMapper.toEntity(clientglentityDTO);
        clientglentity = clientglentityRepository.save(clientglentity);
        return clientglentityMapper.toDto(clientglentity);
    }

    /**
     * Get all the clientglentities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ClientglentityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Clientglentities");
        return clientglentityRepository.findAll(pageable)
            .map(clientglentityMapper::toDto);
    }


    /**
     * Get one clientglentity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ClientglentityDTO> findOne(Long id) {
        log.debug("Request to get Clientglentity : {}", id);
        return clientglentityRepository.findById(id)
            .map(clientglentityMapper::toDto);
    }

    /**
     * Delete the clientglentity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Clientglentity : {}", id);
        clientglentityRepository.deleteById(id);
    }
}
