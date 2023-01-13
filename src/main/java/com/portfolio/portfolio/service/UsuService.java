/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Usuarios;
import com.portfolio.portfolio.repository.UsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class UsuService implements IUsuService{
    @Autowired
    private UsuRepository loginrepo;
    
    @Override
    public Long login(Usuarios acc) {
        Usuarios user = loginrepo.findByUsuario(acc.getUsuario());
        if (user!=null && user.getContrasena().equals(acc.getContrasena())){
            return user.getPersona().getId();
        }
        long res = -1;
        return res;
    }
    
    @Override
    public void deleteUsuario(Long id){
        loginrepo.deleteById(id);
    }
    
    @Override
    public void addUsuario(Usuarios acc){
        loginrepo.save(acc);
    }
}
