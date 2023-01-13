/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Educacion;
import com.portfolio.portfolio.service.IEduService;
import com.portfolio.portfolio.service.IPerService;
import java.awt.print.Pageable;
import java.io.IOException;
import static java.lang.System.console;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author victo
 */

@RestController
public class EduController {
    
    @Autowired
    private IEduService eduserv;
    
    @Autowired
    private IPerService perserv;
    
    @PostMapping(value="/personas/{per_id}/educacion/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long addEducacion(@PathVariable Long per_id, @RequestPart(value="educacion") Educacion edu, @RequestPart(value="imagen", required = false) MultipartFile imagen) throws IOException{
        edu.setPersona(perserv.findPersonas(per_id));
        if(imagen !=null){
            edu.setImagen(imagen.getBytes());
        }
        return eduserv.saveEducacion(edu);
    }
    
    @GetMapping("/personas/{per_id}/educacion/getall")
    public List<Educacion> getEducacion(@PathVariable(value = "per_id") Long per_id){
        return eduserv.getEducacion(per_id);
    }
    
    @DeleteMapping("/personas/{per_id}/educacion/delete/{id}")
    public String deleteEducacion(@PathVariable(value = "id") Long id){
        eduserv.deleteEducacion(id);
        return "borrado exitoso";
    }
    
    @PutMapping(value="/personas/{per_id}/educacion/edit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Educacion editExperience(@PathVariable(value="per_id") Long per_id, @PathVariable(value="id") Long id,
                                @RequestPart(value="educacion") Educacion eduNueva, @RequestPart(value="imagen") MultipartFile imagen) throws IOException{
        Educacion edu = eduserv.findEducacion(id);
        
        edu.setTitulo(eduNueva.getTitulo());
        edu.setInstituto(eduNueva.getInstituto());
        edu.setContacto(eduNueva.getContacto());
        edu.setPeriodo(eduNueva.getPeriodo());
        edu.setDescripcion(eduNueva.getDescripcion());
        if(imagen !=null){
            edu.setImagen(imagen.getBytes());
        }
        
        eduserv.saveEducacion(edu);
        
        return edu;
        
    }
}
