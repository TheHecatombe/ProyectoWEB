/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.dao;

import com.ipn.mx.proyectomanicure.modelo.entidades.Cliente;
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
public class ClienteDAO {

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
            + "                                <li><a class=\"dropdown-item\" href=\"../venta/listaVenta.jsp\">Ver ventas</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../venta/agregarVenta.jsp\">Añadir venta</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Clientes\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"listaCliente.jsp\">Ver clientes</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarCliente.jsp\">Añadir cliente</a></li>\n"
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
    
    public void create(Cliente c) {
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

    public void delete(Cliente c) {
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

    public void update(Cliente c) {
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

    public Cliente read(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            c = session.get(c.getClass(), c.getIdCliente());

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

    public List<Cliente> readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List resultados = new ArrayList();

        try {
            transaction.begin();

            Query q = session.createQuery("from Cliente", Cliente.class);

            resultados = q.list();

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
        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente();
        
        c.setIdCliente(1);
        
        System.out.println(dao.read(c));
    }
}
