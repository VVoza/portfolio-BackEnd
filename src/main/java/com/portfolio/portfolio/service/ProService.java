/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyectos;
import com.portfolio.portfolio.repository.ProRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class ProService implements IProService{
    
    @Autowired
    private ProRepository prorep;

    @Override
    public Long saveProyectos(Proyectos exp) {
        Proyectos savedpro = prorep.save(exp);
        return savedpro.getId();
    }

    @Override
    public List<Proyectos> getProyectos(Long per_id) {
        return prorep.findAllByPersonaId(per_id);
    }

    @Override
    public Proyectos findProyectos(Long id) {
        return prorep.findById(id).orElse(null);
    }
    
    @Override
    public void deleteProyectos(Long id){
        prorep.deleteById(id);
    }
}
