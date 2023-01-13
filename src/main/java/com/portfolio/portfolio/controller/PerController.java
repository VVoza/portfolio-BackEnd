/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Personas;
import com.portfolio.portfolio.service.IPerService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
public class PerController {
    
  @Autowired
    private IPerService perserv;
    
    @PostMapping(value="/personas/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long addPersonas(@RequestPart(value="perfil", required=false) MultipartFile perfil, @RequestPart(value="banner", required=false) MultipartFile banner, @RequestPart(value="persona") Personas per) throws IOException{
        if(perfil!=null){
            per.setPerfil(perfil.getBytes());
        }
        if(banner!=null){
            per.setBanner(banner.getBytes());
        }
       
        return perserv.savePersonas(per);
    }
    
    @GetMapping("/personas/getall")
    public List<Personas> getPersonas(){
        return perserv.getPersonas();
    }
    
    @GetMapping("/personas/find/{per_id}")
    public Personas findPersonas(@PathVariable Long per_id){
        return perserv.findPersonas(per_id);
    }
    
    @PutMapping(value="/personas/edit/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Personas editPersonas(@PathVariable(value="id") Long id,
                                   @RequestPart(value="persona") Personas perNueva, @RequestPart(value="perfil", required=false) MultipartFile perfil, @RequestPart(value="banner", required=false) MultipartFile banner) throws IOException{
        Personas per = perserv.findPersonas(id);
        per.setNombre(perNueva.getNombre());
        per.setApellido(perNueva.getApellido());
        per.setTelefono(perNueva.getTelefono());
        if(perfil!=null){
            per.setPerfil(perfil.getBytes());
        }
        if(banner!=null){
            per.setBanner(banner.getBytes());
        }
        per.setEmail(perNueva.getEmail());
        per.setAcercaDe(perNueva.getAcercaDe());
        
        perserv.savePersonas(per);
        
        return per;
        
    }  
}
