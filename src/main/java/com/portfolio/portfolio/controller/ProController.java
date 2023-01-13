/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Proyectos;
import com.portfolio.portfolio.service.IPerService;
import com.portfolio.portfolio.service.IProService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victo
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
public class ProController {
    
    @Autowired
    private IProService proserv;
    @Autowired
    private IPerService perserv;
    
    @PostMapping("/personas/{per_id}/proyectos/add")
    public Long addProyectos(@PathVariable Long per_id, @RequestPart(value="proyecto") Proyectos pro){
        pro.setPersona(perserv.findPersonas(per_id));
        return proserv.saveProyectos(pro);
    }
    
    @GetMapping("personas/{per_id}/proyectos/getall")
    public List<Proyectos> getProyectos(@PathVariable(value="per_id") Long per_id, Proyectos exp){
        return proserv.getProyectos(per_id);
    }
    
    @PutMapping("/personas/{per_id}/proyectos/edit/{id}")
    public Proyectos editProyectos(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id,
                                @RequestPart(value="proyecto") Proyectos proNuevo){
        Proyectos pro = proserv.findProyectos(id);
        pro.setTitulo(proNuevo.getTitulo());
        pro.setPeriodo(proNuevo.getPeriodo());
        pro.setDescripcion(proNuevo.getDescripcion());
        pro.setLink(proNuevo.getLink());
        
        proserv.saveProyectos(pro);
        
        return pro;
        
    }
    
    @DeleteMapping("/personas/{per_id}/proyectos/delete/{id}")
    public String deleteExperiencias(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id){
        proserv.deleteProyectos(id);
        return "borrado exitoso";
    }
}
