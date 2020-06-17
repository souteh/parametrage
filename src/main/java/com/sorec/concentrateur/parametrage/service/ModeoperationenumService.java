package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Modeoperationenum;
import com.sorec.concentrateur.parametrage.repository.ModeoperationenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.ModeoperationenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.ModeoperationenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Modeoperationenum}.
 */
@Service
@Transactional
public class ModeoperationenumService {

    private final Logger log = LoggerFactory.getLogger(ModeoperationenumService.class);

    private final ModeoperationenumRepository modeoperationenumRepository;

    private final ModeoperationenumMapper modeoperationenumMapper;

    public ModeoperationenumService(ModeoperationenumRepository modeoperationenumRepository, ModeoperationenumMapper modeoperationenumMapper) {
        this.modeoperationenumRepository = modeoperationenumRepository;
        this.modeoperationenumMapper = modeoperationenumMapper;
    }

    /**
     * Save a modeoperationenum.
     *
     * @param modeoperationenumDTO the entity to save.
     * @return the persisted entity.
     */
    public ModeoperationenumDTO save(ModeoperationenumDTO modeoperationenumDTO) {
        log.debug("Request to save Modeoperationenum : {}", modeoperationenumDTO);
        Modeoperationenum modeoperationenum = modeoperationenumMapper.toEntity(modeoperationenumDTO);
        modeoperationenum = modeoperationenumRepository.save(modeoperationenum);
        return modeoperationenumMapper.toDto(modeoperationenum);
    }

    /**
     * Get all the modeoperationenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ModeoperationenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Modeoperationenums");
        return modeoperationenumRepository.findAll(pageable)
            .map(modeoperationenumMapper::toDto);
    }


    /**
     * Get one modeoperationenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ModeoperationenumDTO> findOne(Long id) {
        log.debug("Request to get Modeoperationenum : {}", id);
        return modeoperationenumRepository.findById(id)
            .map(modeoperationenumMapper::toDto);
    }

    /**
     * Delete the modeoperationenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Modeoperationenum : {}", id);
        modeoperationenumRepository.deleteById(id);
    }
}
