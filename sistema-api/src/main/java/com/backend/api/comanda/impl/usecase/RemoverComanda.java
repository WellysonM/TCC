package com.backend.api.comanda.impl.usecase;

import com.backend.api.comanda.impl.bo.ComandaBO;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverComanda {

    @Autowired
    private ComandaBO comandaBO;

    public void removerComanda(ComandaDTO comandaDTO) {
        Comanda categroia = comandaBO.buscarComandaPorId(comandaDTO.getId());
        comandaBO.removerComanda(categroia);
    }
}
