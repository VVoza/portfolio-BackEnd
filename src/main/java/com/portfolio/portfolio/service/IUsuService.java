/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Usuarios;

/**
 *
 * @author victo
 */
public interface IUsuService {
    public Long login(Usuarios acc);
    public void addUsuario(Usuarios acc);
    public void deleteUsuario(Long id);
}
