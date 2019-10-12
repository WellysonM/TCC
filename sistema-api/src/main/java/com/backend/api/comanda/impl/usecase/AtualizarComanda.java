package com.backend.api.comanda.impl.usecase;

import com.backend.api.comanda.impl.bo.ComandaBO;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarComanda {

    @Autowired
    private ComandaBO comandaBO;

    public void atualizarComanda(ComandaDTO comandaDTO) {
        Comanda comanda = comandaBO.buscarComandaPorId(comandaDTO.getId());
        preencherComanda(comanda, comandaDTO);
        comandaBO.atualizarComanda(comanda);
    }

    private static void preencherComanda(Comanda comanda, ComandaDTO comandaDTO) {
        comanda.setId(comandaDTO.getId());
        comanda.setMesa(comandaDTO.getMesa());
        comanda.setPedidos(comandaDTO.getPedidos());
    }
}