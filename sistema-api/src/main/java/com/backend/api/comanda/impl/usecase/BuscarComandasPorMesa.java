package com.backend.api.comanda.impl.usecase;

import com.backend.api.comanda.impl.bo.ComandaBO;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarComandasPorMesa {

    @Autowired
    private ComandaBO comandaBO;

    public List<ComandaDTO> buscarComandasPorMesa(String mesaId) {
        List<Comanda> comandas = comandaBO.buscarComadasPorMesa(mesaId);
        return converterComandaParaDTO(comandas);
    }

    private List<ComandaDTO> converterComandaParaDTO(List<Comanda> comandas) {
        List<ComandaDTO> comandaDTO = new ArrayList<>();
        comandas.forEach(comanda -> comandaDTO.add(montarComandaDTO(comanda)));
        return comandaDTO;
    }

    public static ComandaDTO montarComandaDTO(Comanda comanda) {
        ComandaDTO comandaDTO = new ComandaDTO(comanda);
        return comandaDTO;
    }
}