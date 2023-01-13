/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Personas;
import com.portfolio.portfolio.model.Usuarios;
import com.portfolio.portfolio.service.IPerService;
import com.portfolio.portfolio.service.IUsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victo
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
public class UsuController {
    
    @Autowired
    private IUsuService loginserv;
    @Autowired
    private IPerService perserv;
    
    @PostMapping("/authenticate/login")
    public Long auth(@RequestBody Usuarios acc){
        return loginserv.login(acc);
    }
    
    @DeleteMapping("/authenticate/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        loginserv.deleteUsuario(id);
        return "borrado";
    }
    
    @PostMapping("/authenticate/create")
    public String addUser(@RequestBody Usuarios acc){
        Personas per = new Personas();
        per.setEmail(acc.getEmail());
        Long per_id = perserv.savePersonas(per);
        acc.setPersona(perserv.findPersonas(per_id));
        loginserv.addUsuario(acc);
        return "usuario añadido";
    }
}
