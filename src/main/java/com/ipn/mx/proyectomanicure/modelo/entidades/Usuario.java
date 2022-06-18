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
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "userName", length = 30, nullable = false)
    private String useName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "nombreUsuario", length = 50, nullable = false)
    private String nombreUsuario;

    @Column(name = "paternoUsuario", length = 50, nullable = false)
    private String paternoUsuario;

    @Column(name = "maternoUsuario", length = 50, nullable = false)
    private String maternoUsuario;

    @Column(name = "tipoUsuario", length = 20, nullable = false)
    private String tipoUsuario;
    
    
    //Relaciones
    
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Venta> ventas = new ArrayList<>();

//    public static void main(String[] args) {
//
//        EntityManager em = JPAUtil.getEntityManager();
//        
//        try {
//            Usuario u = new Usuario();
//            u.setUseName("vendedor1");
//            u.setPassword("hola");
//            u.setNombreUsuario("Maria");
//            u.setPaternoUsuario("Borrego");
//            u.setMaternoUsuario("Sora");
//            u.setTipoUsuario("Vendedor");
//
//            em.getTransaction().begin();
//
//            em.persist(u);
//
//            em.getTransaction().commit();
//
//            System.out.println("El id del usuario registrado es: " + u.getIdUsuario());
//
//            u = em.find(Usuario.class, u.getIdUsuario());
//
//            System.out.println(u);
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }
    
    
}
