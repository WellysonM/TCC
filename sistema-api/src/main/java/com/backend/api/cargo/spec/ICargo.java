package com.backend.api.cargo.spec;

import com.backend.api.cargo.spec.dto.CargoDTO;

import java.util.List;

public interface ICargo {

    List<CargoDTO> buscarCargos();

    void removerCargo(CargoDTO cargoDTO);

    void inserirCargo(CargoDTO cargoDTO);

    void atualizarCargo(CargoDTO cargoDTO);
}