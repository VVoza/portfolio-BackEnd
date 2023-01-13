/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author victo
 */
@Entity @Getter @Setter
public class Proyectos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String periodo;
    private String descripcion;
    private String link;
    
    @JsonIgnore
    @ManyToOne
    @JoinTable(name="personas-proyectos",
               joinColumns={@JoinColumn(name="proyectos_id")},
               inverseJoinColumns={@JoinColumn(name="personas_id")})
    private Personas persona;
}
