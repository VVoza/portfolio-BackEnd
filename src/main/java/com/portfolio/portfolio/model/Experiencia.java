/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author victo
 */
@Entity @Getter @Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
    private String puesto;
    private String empresa;
    private String contacto;
    private String periodo;
    private String descripcion;
    
    @JsonIgnore
    @ManyToOne
    @JoinTable(name="personas-experiencia",
               joinColumns={@JoinColumn(name="experiencia_id")},
               inverseJoinColumns={@JoinColumn(name="personas_id")})
    private Personas persona;
}

