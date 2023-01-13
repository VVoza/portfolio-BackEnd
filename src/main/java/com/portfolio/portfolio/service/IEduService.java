/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Educacion;
import java.awt.print.Pageable;
import java.util.List;

/**
 *
 * @author victo
 */
public interface IEduService {
    public Long saveEducacion(Educacion edu);
    public List<Educacion> getEducacion(Long per_id);
    public Educacion findEducacion(Long id);
    public void deleteEducacion(Long id);
}
