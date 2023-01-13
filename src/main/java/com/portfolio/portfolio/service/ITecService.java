/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tecnologias;
import java.util.List;

/**
 *
 * @author victo
 */
public interface ITecService {
    public Long saveTecnologias(Tecnologias exp);
    public List<Tecnologias> getTecnologias(Long id);
    public Tecnologias findTecnologias(Long id);
    public void deleteTecnologias(Long id);
}
