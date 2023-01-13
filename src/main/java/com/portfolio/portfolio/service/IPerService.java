/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Personas;
import java.util.List;

/**
 *
 * @author victo
 */
public interface IPerService {
    public Long savePersonas(Personas per);
    public List<Personas> getPersonas();
    public Personas findPersonas(Long id);
    
}
