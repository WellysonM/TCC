package com.backend.api.mesa.impl.usecase;

import com.backend.api.mesa.impl.bo.MesaBO;
import com.backend.api.mesa.spec.dto.MesaDTO;
import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarMesa {

    @Autowired
    private MesaBO mesaBO;

    public void atualizarMesa(MesaDTO mesaDTO) {
        Mesa mesa = mesaBO.buscarMesaPorId(mesaDTO.getId());
        preencherMesa(mesa, mesaDTO);
        mesaBO.atualizarMesa(mesa);
    }

    private static void preencherMesa(Mesa mesa, MesaDTO mesaDTO) {
        mesa.setId(mesaDTO.getId());
        mesa.setNumero(mesaDTO.getNumero());
    }
}
