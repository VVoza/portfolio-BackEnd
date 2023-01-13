/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author victo
 */
@Entity @Getter @Setter
public class Personas {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] perfil;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] banner;
    private Long telefono;
    private String email;
    private String acercaDe;
    
    @JsonIgnore
    @OneToOne(mappedBy = "persona")
    private Usuarios usuario;
    
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Educacion> eduPers;
    
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Experiencia> expPers;
    
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Proyectos> proPers;
    
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Tecnologias> tecPers;
    
}

