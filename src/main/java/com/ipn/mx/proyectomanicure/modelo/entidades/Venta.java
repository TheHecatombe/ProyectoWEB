/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
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
@Table(name = "Venta")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVenta", nullable = false)
    private Date fechaVenta;
    
//    @Column(name = "idCliente", nullable = false)
//    private int idCliente;
    
    // Relaciones
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "VentaProducto",
            joinColumns = @JoinColumn (name = "idVenta"), 
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private List<Producto> productos = new ArrayList<>();
    
    @Override
    public String toString(){
        String salida = "Venta: \n\n";
        salida += "Id: " + this.idVenta + "\n";
        salida += "Fecha: " + this.fechaVenta + "\n";
        salida += "Vendedor: " + this.usuario.getNombreUsuario() + " " + this.usuario.getPaternoUsuario() + " " + this.usuario.getMaternoUsuario() + "\n";
        salida += "Productos (" + this.productos.size() + "): \n";
        
        for(int i = 0; i < this.productos.size(); i++){
            salida += "[" + (i+1) + "]: " + this.productos.get(i).getNombreProducto() + "\n";
        }
        
        return salida;
    }
}
