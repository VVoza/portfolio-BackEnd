/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Tecnologias;
import com.portfolio.portfolio.service.IPerService;
import com.portfolio.portfolio.service.ITecService;
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
public class TecController {
    
    @Autowired
    private ITecService tecserv;
    @Autowired
    private IPerService perserv;
    
    @PostMapping("/personas/{per_id}/tecnologias/add")
    public Long addTecnologias(@PathVariable Long per_id, @RequestPart(value="tecnologia") Tecnologias tec){
        tec.setPersona(perserv.findPersonas(per_id));
        return tecserv.saveTecnologias(tec);
    }
    
    @GetMapping("/personas/{per_id}/tecnologias/getall")
    public List<Tecnologias> getTecnologias(@PathVariable Long per_id){
        return tecserv.getTecnologias(per_id);
    }
    
    @PutMapping("/personas/{per_id}/tecnologias/edit/{id}")
    public Tecnologias editTecnologias(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id,
                                @RequestPart(value="tecnologia") Tecnologias tecNueva){
        Tecnologias tec = tecserv.findTecnologias(id);
        tec.setNombre(tecNueva.getNombre());
        tec.setDescripcion(tecNueva.getDescripcion());
        tec.setMaestria(tecNueva.getMaestria());
        tec.setTipo(tecNueva.getTipo());
        tecserv.saveTecnologias(tec);
        
        return tec;
        
    }
    
    @DeleteMapping("/personas/{per_id}/tecnologias/delete/{id}")
    public String deleteExperiencias(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id){
        tecserv.deleteTecnologias(id);
        return "borrado exitoso";
    }
}
