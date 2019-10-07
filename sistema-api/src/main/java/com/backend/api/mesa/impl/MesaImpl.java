package com.backend.api.mesa.impl;

import com.backend.api.mesa.impl.usecase.AtualizarMesa;
import com.backend.api.mesa.impl.usecase.BuscarMesa;
import com.backend.api.mesa.impl.usecase.InserirMesa;
import com.backend.api.mesa.impl.usecase.RemoverMesa;
import com.backend.api.mesa.spec.IMesa;
import com.backend.api.mesa.spec.dto.MesaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MesaImpl implements IMesa {

    @Autowired
    private BuscarMesa buscar;

    @Autowired
    private InserirMesa inserir;

    @Autowired
    private AtualizarMesa atualizar;

    @Autowired
    private RemoverMesa remover;

    @Override
    public List<MesaDTO> buscarMesas() {
        return buscar.buscarMesas();
    }

    @Override
    public void removerMesa(MesaDTO mesaDTOId) {
        remover.removerMesa(mesaDTOId);
    }

    @Override
    public void inserirMesa(MesaDTO mesaDTO) {
        inserir.inserirMesa(mesaDTO);
    }

    @Override
    public void atualizarMesa(MesaDTO mesaDTO) {
        atualizar.atualizarMesa(mesaDTO);
    }
}