/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Experiencia;
import com.portfolio.portfolio.service.IExpService;
import com.portfolio.portfolio.service.IPerService;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author victo
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
public class ExpController {
    
    @Autowired
    private IExpService expserv;
    @Autowired
    private IPerService perserv;
    
    
    @PostMapping(value="/personas/{per_id}/experiencia/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long addExperiencia(@PathVariable(value="per_id") Long per_id,
            @RequestPart(value="experiencia") Experiencia exp, @RequestPart(value="imagen", required=false) MultipartFile imagen) throws IOException{
        
        if(imagen!=null){
            exp.setImg(imagen.getBytes());
        }
        exp.setPersona(perserv.findPersonas(per_id));
        
        
        return expserv.saveExperiencia(exp);
    }
    
    @GetMapping("/personas/{per_id}/experiencia/getall")
    public List<Experiencia> getExperiences(@PathVariable(value="per_id") Long per_id){
        return expserv.getExperiencia(per_id);
    }
    
    @PutMapping(value="/personas/{per_id}/experiencia/edit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Experiencia editExperience(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id,
                                @RequestPart(value="experiencia") Experiencia expNueva, @RequestPart(value="imagen", required=false) MultipartFile imagen) throws IOException{
        Experiencia exp = expserv.findExperiencia(id);
        
        if(imagen!=null){
            exp.setImg(imagen.getBytes());
        }
        exp.setPuesto(expNueva.getPuesto());
        exp.setEmpresa(expNueva.getEmpresa());
        exp.setContacto(expNueva.getContacto());
        exp.setPeriodo(expNueva.getPeriodo());
        exp.setDescripcion(expNueva.getDescripcion());
        expserv.saveExperiencia(exp);
        
        return exp;
        
    }
    
    @DeleteMapping("/personas/{per_id}/experiencia/delete/{id}")
    public String deleteExperiencias(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id){
        expserv.deleteExperiencia(id);
        return "borrado exitoso";
    }
}
