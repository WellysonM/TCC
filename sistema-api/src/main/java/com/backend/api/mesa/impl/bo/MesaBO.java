package com.backend.api.mesa.impl.bo;

import com.backend.api.mesa.impl.repository.MesaRepository;
import com.backend.api.mesa.spec.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MesaBO {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> buscarMesas() {
        return mesaRepository.findAll(Sort.by("numero").ascending());
    }

    public Mesa inserirMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa atualizarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa buscarMesaPorId(String id) {
        return mesaRepository.findById(id).get();
    }

    public void removerMesa(Mesa mesa) {
        mesaRepository.delete(mesa);
    }
}