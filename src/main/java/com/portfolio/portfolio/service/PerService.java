/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Personas;
import com.portfolio.portfolio.repository.PerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class PerService implements IPerService{
    
    @Autowired
    private PerRepository perrep;

    @Override
    public Long savePersonas(Personas per) {
        Personas savededu = perrep.save(per);
        return savededu.getId();
    }

    @Override
    public List<Personas> getPersonas() {
        return perrep.findAll();
    }

    @Override
    public Personas findPersonas(Long id) {
        return perrep.findById(id).orElse(null);
    }
}
