package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.VoucherDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Voucher} and its DTO {@link VoucherDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VoucherMapper extends EntityMapper<VoucherDTO, Voucher> {



    default Voucher fromId(Long id) {
        if (id == null) {
            return null;
        }
        Voucher voucher = new Voucher();
        voucher.setId(id);
        return voucher;
    }
}
