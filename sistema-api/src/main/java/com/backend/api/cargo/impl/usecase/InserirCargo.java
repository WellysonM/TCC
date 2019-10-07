package com.backend.api.cargo.impl.usecase;

import com.backend.api.cargo.impl.bo.CargoBO;
import com.backend.api.cargo.spec.dto.CargoDTO;
import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirCargo {

    @Autowired
    private CargoBO cargoBO;

    public void inserirCargo(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        preencherCargo(cargo, cargoDTO);
        cargoBO.inserirCargo(cargo);
    }

    private static void preencherCargo(Cargo cargo, CargoDTO cargoDTO) {
        cargo.setCargo(cargoDTO.getCargo());
    }
}