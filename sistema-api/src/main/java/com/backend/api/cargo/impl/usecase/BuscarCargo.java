package com.backend.api.cargo.impl.usecase;

import com.backend.api.cargo.impl.bo.CargoBO;
import com.backend.api.cargo.spec.dto.CargoDTO;
import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarCargo {

    @Autowired
    private CargoBO cargoBO;

    public List<CargoDTO> buscarCargo() {
        List<Cargo> cargos = cargoBO.buscarCargos();
        return converterCargoParaDTO(cargos);
    }

    private List<CargoDTO> converterCargoParaDTO(List<Cargo> cargos) {
        List<CargoDTO> cargoDTO = new ArrayList<>();
        cargos.forEach(cargo -> cargoDTO.add(montarCargoDTO(cargo)));
        return cargoDTO;
    }

    public static CargoDTO montarCargoDTO(Cargo cargo) {
        CargoDTO cargoDTO = new CargoDTO(cargo);
        return cargoDTO;
    }
}