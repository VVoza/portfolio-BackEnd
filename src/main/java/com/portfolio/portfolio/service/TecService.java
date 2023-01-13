/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tecnologias;
import com.portfolio.portfolio.repository.TecRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class TecService implements ITecService{
    @Autowired
    private TecRepository tecrep;

    @Override
    public Long saveTecnologias(Tecnologias exp) {
        Tecnologias savedexp = tecrep.save(exp);
        return savedexp.getId();
    }

    @Override
    public List<Tecnologias> getTecnologias(Long per_id) {
        return tecrep.findAllByPersonaId(per_id);
    }

    @Override
    public Tecnologias findTecnologias(Long id) {
        return tecrep.findById(id).orElse(null);
    }
    
    @Override
    public void deleteTecnologias(Long id){
        tecrep.deleteById(id);
    }
}
