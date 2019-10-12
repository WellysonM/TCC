package com.backend.api.cargo.impl;

import com.backend.api.cargo.impl.usecase.AtualizarCargo;
import com.backend.api.cargo.impl.usecase.BuscarCargo;
import com.backend.api.cargo.impl.usecase.InserirCargo;
import com.backend.api.cargo.impl.usecase.RemoverCargo;
import com.backend.api.cargo.spec.ICargo;
import com.backend.api.cargo.spec.dto.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoImpl implements ICargo {

    @Autowired
    private BuscarCargo buscar;

    @Autowired
    private InserirCargo inserir;

    @Autowired
    private AtualizarCargo atualizar;

    @Autowired
    private RemoverCargo remover;

    @Override
    public List<CargoDTO> buscarCargos() {
        return buscar.buscarCargo();
    }

    @Override
    public void removerCargo(CargoDTO cargoDTOId) {
        remover.removerCargo(cargoDTOId);
    }

    @Override
    public void inserirCargo(CargoDTO cargoDTO) {
        inserir.inserirCargo(cargoDTO);
    }

    @Override
    public void atualizarCargo(CargoDTO cargoDTO) {
        atualizar.atualizarCargo(cargoDTO);
    }
}
