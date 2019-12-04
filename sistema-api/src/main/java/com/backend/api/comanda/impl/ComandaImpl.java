package com.backend.api.comanda.impl;

import com.backend.api.comanda.impl.usecase.*;
import com.backend.api.comanda.spec.IComanda;
import com.backend.api.comanda.spec.dto.ComandaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComandaImpl implements IComanda {

    @Autowired
    private BuscarComanda buscar;

    @Autowired
    private InserirComanda inserir;

    @Autowired
    private AtualizarComanda atualizar;

    @Autowired
    private RemoverComanda remover;

    @Autowired
    private BuscarComandasPorMesa buscarComandasPorMesa;

    @Override
    public List<ComandaDTO> buscarComandas() {
        return buscar.buscarComandas();
    }

    @Override
    public List<ComandaDTO> buscarComandasPorMesa(String mesaId){
        return buscarComandasPorMesa.buscarComandasPorMesa(mesaId);
    }

    @Override
    public void removerComanda(ComandaDTO comandaDTOId) {
        remover.removerComanda(comandaDTOId);
    }

    @Override
    public void inserirComanda(ComandaDTO comandaDTO) {
        inserir.inserirComanda(comandaDTO);
    }

    @Override
    public void atualizarComanda(ComandaDTO comandaDTO) {
        atualizar.atualizarComanda(comandaDTO);
    }
}