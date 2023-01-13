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
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author victo
 */
@Entity @Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] imagen;
    private String titulo;
    private String instituto;
    private String contacto;
    private String periodo;
    private String descripcion;
    
    @JsonIgnore
    @ManyToOne
    @JoinTable(name="personas-educacion",
               joinColumns={@JoinColumn(name="educacion_id")},
               inverseJoinColumns={@JoinColumn(name="personas_id")})
    private Personas persona;
}

