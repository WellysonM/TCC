package com.backend.api.mesa.impl.usecase;

import com.backend.api.mesa.impl.bo.MesaBO;
import com.backend.api.mesa.spec.dto.MesaDTO;
import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarMesa {

    @Autowired
    private MesaBO mesaBO;

    public List<MesaDTO> buscarMesas() {
        List<Mesa> mesas = mesaBO.buscarMesas();
        return converterMesaParaDTO(mesas);
    }

    private List<MesaDTO> converterMesaParaDTO(List<Mesa> mesas) {
        List<MesaDTO> mesaDTO = new ArrayList<>();
        mesas.forEach(mesa -> mesaDTO.add(montarMesaDTO(mesa)));
        return mesaDTO;
    }

    public static MesaDTO montarMesaDTO(Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa);
        return mesaDTO;
    }
}
