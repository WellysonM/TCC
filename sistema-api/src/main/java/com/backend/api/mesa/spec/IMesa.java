package com.backend.api.mesa.spec;

import com.backend.api.mesa.spec.dto.MesaDTO;

import java.util.List;

public interface IMesa {

    List<MesaDTO> buscarMesas();

    void removerMesa(MesaDTO mesaDTO);

    void inserirMesa(MesaDTO mesaDTO);

    void atualizarMesa(MesaDTO mesaDTO);
}
