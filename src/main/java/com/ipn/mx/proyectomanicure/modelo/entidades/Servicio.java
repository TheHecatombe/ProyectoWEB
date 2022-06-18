/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
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
@Table(name = "Servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    
    @Column(name = "precioServicio", nullable = false)
    private double precioServicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaServicio", nullable = false)
    private Date fechaServicio;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name  = "idUsuario")
    private Usuario usuario;
    
    @Override
    public String toString(){
        String salida = "Servicio: \n";
        salida += "Id: " + this.idServicio + "\n";
        salida += "Precio: " + this.precioServicio + "\n";
        salida += "Fecha: " + this.fechaServicio + "\n";
        salida += "Cliente: " + this.cliente.getNombreCliente() + " " + this.cliente.getPaternoCliente() + " " + this.cliente.getMaternoCliente()+ "\n";
        salida += "Vendedor: " + this.usuario.getNombreUsuario() + " " + this.usuario.getPaternoUsuario() + " " + this.usuario.getMaternoUsuario()+ "\n";
        
        return salida;
    }
}
