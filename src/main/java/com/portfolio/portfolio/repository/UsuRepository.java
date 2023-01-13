/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victo
 */
@Repository
public interface UsuRepository extends JpaRepository <Usuarios,Long>{
    Usuarios findByUsuario(String email);
}
