package com.backend.api.comanda.impl.usecase;

import com.backend.api.comanda.impl.bo.ComandaBO;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirComanda {

    @Autowired
    private ComandaBO comandaBO;

    public void inserirComanda(ComandaDTO comandaDTO) {
        Comanda comanda = new Comanda();
        preencherComanda(comanda, comandaDTO);
        comandaBO.inserirComanda(comanda);
    }

    private static void preencherComanda(Comanda comanda, ComandaDTO comandaDTO) {
        comanda.setMesa(comandaDTO.getMesa());
        comanda.setPedidos(comandaDTO.getPedidos());
    }
}