/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.dao;

import com.ipn.mx.proyectomanicure.modelo.entidades.Producto;
import com.ipn.mx.proyectomanicure.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author jonathan
 */
public class ProductoDAO {

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
            + "                                <li><a class=\"dropdown-item\" href=\"listaProducto.jsp\">Ver productos</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarProducto.jsp\">Añadir producto</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Venta\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../venta/listaVenta.jsp\">Ver ventas</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../venta/agregarVenta.jsp\">Añadir venta</a></li>\n"
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

    public void create(Producto c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.persist(c);

            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void delete(Producto c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.remove(c);

            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void update(Producto c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.merge(c);

            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public Producto read(Producto c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            c = session.get(c.getClass(), c.getIdProducto());

            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return c;
    }

    public List<Producto> readAll() {

        System.out.println("READALL");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List resultados = new ArrayList();

        try {
            transaction.begin();

            Query q = session.createQuery("from Producto", Producto.class);

            resultados = q.list();

//            System.out.println("Resultados: " + resultados);

            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return resultados;
    }

    public static void main(String[] args) {
        ProductoDAO pdao = new ProductoDAO();
//        Producto p = new Producto();

        for (Producto p : pdao.readAll()) {
            System.out.println(p.toString());
        }
    }
}
