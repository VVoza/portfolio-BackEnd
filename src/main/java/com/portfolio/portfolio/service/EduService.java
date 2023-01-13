/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;


import com.portfolio.portfolio.repository.EduRepository;
import com.portfolio.portfolio.model.Educacion;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class EduService implements IEduService{
    
    @Autowired
    private EduRepository edurep;

    @Override
    public Long saveEducacion(Educacion edu) {
        Educacion savededu = edurep.save(edu);
        return savededu.getId();
    }

    @Override
    public List<Educacion> getEducacion(Long per_id) {
        return edurep.findAllByPersonaId(per_id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return edurep.findById(id).orElse(null);
    }
    
    @Override
    public void deleteEducacion(Long id){
        edurep.deleteById(id);
    }
    
}
