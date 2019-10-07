package com.backend.api.cargo.impl.bo;

import com.backend.api.cargo.impl.repository.CargoRepository;
import com.backend.api.cargo.spec.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoBO {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> buscarCargos() {
        return cargoRepository.findAll(Sort.by("cargo").ascending());
    }

    public Cargo inserirCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo atualizarCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo buscarCargoPorId(String id) {
        return cargoRepository.findById(id).get();
    }

    public void removerCargo(Cargo cargo) {
        cargoRepository.delete(cargo);
    }
}