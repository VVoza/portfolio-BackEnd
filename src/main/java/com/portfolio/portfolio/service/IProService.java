/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyectos;
import java.util.List;

/**
 *
 * @author victo
 */
public interface IProService {
    public Long saveProyectos(Proyectos pro);
    public List<Proyectos> getProyectos(Long per_id);
    public Proyectos findProyectos(Long id);
    public void deleteProyectos(Long id);
}
