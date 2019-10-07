package com.backend.api.mesa.impl.usecase;

import com.backend.api.mesa.impl.bo.MesaBO;
import com.backend.api.mesa.spec.dto.MesaDTO;
import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverMesa {

    @Autowired
    private MesaBO mesaBO;

    public void removerMesa(MesaDTO mesaDTO) {
        Mesa mesa = mesaBO.buscarMesaPorId(mesaDTO.getId());
        mesaBO.removerMesa(mesa);
    }
}
