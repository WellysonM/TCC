package com.backend.api.cargo.impl.usecase;

import com.backend.api.cargo.impl.bo.CargoBO;
import com.backend.api.cargo.spec.dto.CargoDTO;
import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverCargo {

    @Autowired
    private CargoBO cargoBO;

    public void removerCargo(CargoDTO cargoDTO) {
        Cargo categroia = cargoBO.buscarCargoPorId(cargoDTO.getId());
        cargoBO.removerCargo(categroia);
    }
}
