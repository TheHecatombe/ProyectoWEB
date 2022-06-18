/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jonathan
 */
@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column(name = "nombreCliente", length = 50, nullable = false)
    private String nombreCliente;
    
    @Column(name = "paternoCliente", length = 50, nullable = false)
    private String paternoCliente;
    
    @Column(name = "maternoCliente", length = 50, nullable = false)
    private String maternoCliente;
    
    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;
    
    // Relaciones
    
    public static void main(String[] args) {
        Cliente c = new Cliente();
        
//        c.get
    }
    
}
