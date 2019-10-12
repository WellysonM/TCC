package com.backend.api.cargo.impl.usecase;

import com.backend.api.cargo.impl.bo.CargoBO;
import com.backend.api.cargo.spec.dto.CargoDTO;
import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarCargo {

    @Autowired
    private CargoBO cargoBO;

    public void atualizarCargo(CargoDTO cargoDTO) {
        Cargo cargo = cargoBO.buscarCargoPorId(cargoDTO.getId());
        preencherCargo(cargo, cargoDTO);
        cargoBO.atualizarCargo(cargo);
    }

    private static void preencherCargo(Cargo cargo, CargoDTO cargoDTO) {
        cargo.setId(cargoDTO.getId());
        cargo.setCargo(cargoDTO.getCargo());
    }
}