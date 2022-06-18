/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    
    @Column(name = "nombreProducto", length = 50, nullable = false)
    private String nombreProducto;
    
    @Column(name = "descripcionProducto", length = 100, nullable = false)
    private String descripcionProducto;
    
    @Column(name = "precioProducto", nullable = false)
    private double precioProducto;
    
    @Column(name = "stockProducto", nullable = false)
    private int stockProducto;
    
    @Override
    public String toString(){
        String salida = "Producto: \n\n";
        salida += "Id: " + this.idProducto + "\n";
        salida += "Nombre: " + this.nombreProducto + "\n";
        salida += "Descripcion: " + this.descripcionProducto + "\n";
        salida += "Precio: " + this.precioProducto + "\n";
        salida += "Stock: " + this.stockProducto + "\n";
        
        return salida;
    }
}
