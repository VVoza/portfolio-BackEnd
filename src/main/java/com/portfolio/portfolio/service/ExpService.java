/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Experiencia;
import com.portfolio.portfolio.repository.ExpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class ExpService implements IExpService{
    
    @Autowired
    private ExpRepository edurep;

    @Override
    public Long saveExperiencia(Experiencia edu) {
        Experiencia savededu = edurep.save(edu);
        return savededu.getId();
    }

    @Override
    public List<Experiencia> getExperiencia(Long per_id) {
        return edurep.findAllByPersonaId(per_id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        return edurep.findById(id).orElse(null);
    }
    
    @Override
    public void deleteExperiencia(Long id){
        edurep.deleteById(id);
    }
    
}
