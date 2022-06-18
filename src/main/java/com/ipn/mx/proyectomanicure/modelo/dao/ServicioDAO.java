/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.dao;

import com.ipn.mx.proyectomanicure.modelo.entidades.Cliente;
import com.ipn.mx.proyectomanicure.modelo.entidades.Servicio;
import com.ipn.mx.proyectomanicure.modelo.entidades.Usuario;
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
public class ServicioDAO {
    public void create(Servicio c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.persist(c);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void delete(Servicio c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.remove(c);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void update(Servicio c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            session.merge(c);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public Servicio read(Servicio c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            c = session.get(c.getClass(), c.getIdServicio());

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return c;
    }

    public List readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List resultados = new ArrayList();

        try {
            transaction.begin();

            Query q = session.createQuery("from Servicio", Servicio.class);

            resultados = q.list();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return resultados;
    }
    
    public static void main(String[] args) {
        Cliente c = new Cliente();
        ClienteDAO cdao = new ClienteDAO();
        
        Usuario u = new Usuario();
        UsuarioDAO udao = new UsuarioDAO();
        
        Servicio s = new Servicio();
        ServicioDAO sdao = new ServicioDAO();
        
        u.setIdUsuario(2);
        u = udao.read(u);
        System.out.println(u);
        
        c.setIdCliente(1);
        c = cdao.read(c);
        System.out.println(c);
        
        s.setPrecioServicio(500);
        s.setFechaServicio(new Date());
        s.setCliente(c);
        s.setUsuario(u);
        
        s.setIdServicio(2);
        sdao.update(s);
        
        s.setIdServicio(1);
        
        System.out.println("");
        System.out.println("");
        System.out.println(sdao.read(s));
        System.out.println("");
    }
}
