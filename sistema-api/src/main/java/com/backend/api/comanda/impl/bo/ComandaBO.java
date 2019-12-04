package com.backend.api.comanda.impl.bo;

import com.backend.api.comanda.impl.repository.ComandaRepository;
import com.backend.api.comanda.spec.entity.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComandaBO {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> buscarComandas() {
        return comandaRepository.findAll(Sort.by("id").ascending());
    }

    public List<Comanda> buscarComadasPorMesa(String mesaId) {
        return comandaRepository.findAllByMesa_Id(mesaId);
    }

    public Comanda inserirComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    public Comanda atualizarComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    public Comanda buscarComandaPorId(String id) {
        return comandaRepository.findById(id).get();
    }

    public void removerComanda(Comanda comanda) {
        comandaRepository.delete(comanda);
    }
}