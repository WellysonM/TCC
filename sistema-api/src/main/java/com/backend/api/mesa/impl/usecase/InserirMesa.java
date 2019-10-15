package com.backend.api.mesa.impl.usecase;

import com.backend.api.mesa.impl.bo.MesaBO;
import com.backend.api.mesa.spec.dto.MesaDTO;
import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirMesa {

    @Autowired
    private MesaBO mesaBO;

    public void inserirMesa(MesaDTO mesaDTO) {
        Mesa mesa = new Mesa();
        preencherMesa(mesa, mesaDTO);
        mesaBO.inserirMesa(mesa);
    }

    private static void preencherMesa(Mesa mesa, MesaDTO mesaDTO) {
        mesa.setNumero(mesaDTO.getNumero());
        mesa.setStatus(mesaDTO.getStatus());
    }
}