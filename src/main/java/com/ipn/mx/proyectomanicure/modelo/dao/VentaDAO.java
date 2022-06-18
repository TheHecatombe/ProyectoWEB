/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.dao;

import com.ipn.mx.proyectomanicure.modelo.entidades.Producto;
import com.ipn.mx.proyectomanicure.modelo.entidades.Usuario;
import com.ipn.mx.proyectomanicure.modelo.entidades.Venta;
import com.ipn.mx.proyectomanicure.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author jonathan
 */
public class VentaDAO {

    private String navbar = "<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark\">\n"
            + "            <div class=\"container-fluid\">\n"
            + "                <a class=\"navbar-brand\" href=\"../index.jsp\">Manicure</a>\n"
            + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
            + "                    <span class=\"navbar-toggler-icon\"></span>\n"
            + "                </button>\n"
            + "                <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n"
            + "                    <ul class=\"navbar-nav\">\n"
            + "                        <li class=\"nav-item\">\n"
            + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"../index.jsp\">Inicio</a>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Productos\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../producto/listaProducto.jsp\">Ver productos</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../producto/agregarProducto.jsp\">Añadir producto</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Venta\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"listaVenta.jsp\">Ver ventas</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarVenta.jsp\">Añadir venta</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Clientes\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../cliente/listaCliente.jsp\">Ver clientes</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../cliente/agregarCliente.jsp\">Añadir cliente</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item\">\n"
            + "                            <a href=\"../login/logout.jsp\" class=\"nav-link\">Logout</a>\n"
            + "                        </li>"
            + "                    </ul>\n"
            + "                </div>\n"
            + "            </div>\n"
            + "        </nav>";

    public String getNavbar() {
        return navbar;
    }

    public void create(Venta v) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se guardara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.persist(v); // Persistimos ek objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR Hibernate: " + e);
        } catch (Exception e) {
            System.err.println("ERROR Normal: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void delete(Venta v) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se borrara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.remove(v); // Eliminamos el objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void update(Venta v) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se actualizara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.merge(v); // Actualizamos el objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public Venta read(Venta v) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {

            transaction.begin(); // Iniciamos la transacion

            v = session.get(v.getClass(), v.getIdVenta());

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return v;
    }

    public List<Venta> readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List ventas = new ArrayList<>();

        try {

            transaction.begin(); // Iniciamos la transacion

            Query q = session.createQuery("from Venta", Venta.class);

            ventas = (ArrayList<Venta>) q.list();

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return ventas;
    }

    public static void main(String[] args) {
        VentaDAO vdao = new VentaDAO();
        Venta v = new Venta();

//        ProductoDAO pdao = new ProductoDAO();
//        Producto p = new Producto();
//
//        UsuarioDAO cdao = new UsuarioDAO();
//        Usuario u = new Usuario();
//        
//        u.setIdUsuario(2);
//        u = cdao.read(u);
//        
//        v.setUsuario(u);
//
//        p.setIdProducto(1);
//        p = pdao.read(p);
//        v.getProductos().add(new Producto(p.getIdProducto(), p.getNombreProducto(), p.getDescripcionProducto(), p.getPrecioProducto(), p.getStockProducto()));
//
//        p.setIdProducto(2);
//        p = pdao.read(p);
//        v.getProductos().add(new Producto(p.getIdProducto(), p.getNombreProducto(), p.getDescripcionProducto(), p.getPrecioProducto(), p.getStockProducto()));
//
//        v.setFechaVenta(new Date());
////        v.setUsuario(u);
//
//        v.setIdVenta(18);
//
//        System.out.println("Venta antes de guardar" + v);
//
//        vdao.update(v);
        
        System.out.println(vdao.readAll());
//        v.setIdVenta(0);
//        v = vdao.read(v);
//
//        System.out.println("Venta despues de guardar" + v);

//        
    }
}
