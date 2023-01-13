/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author victo
 */
public interface IExpService {
    public Long saveExperiencia(Experiencia exp);
    public List<Experiencia> getExperiencia(Long per_id);
    public Experiencia findExperiencia(Long id);
    public void deleteExperiencia(Long id);
}
