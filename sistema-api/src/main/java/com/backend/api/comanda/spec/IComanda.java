package com.backend.api.comanda.spec;

import com.backend.api.comanda.spec.dto.ComandaDTO;

import java.util.List;

public interface IComanda {

    List<ComandaDTO> buscarComandas();

    List<ComandaDTO> buscarComandasPorMesa(String Id);

    void removerComanda(ComandaDTO comandaDTO);

    void inserirComanda(ComandaDTO comandaDTO);

    void atualizarComanda(ComandaDTO comandaDTO);
}