/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.proyectomanicure.modelo.dao;

import com.ipn.mx.proyectomanicure.modelo.entidades.Usuario;
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
public class UsuarioDAO {

    public void create(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            System.out.println("Se guardara: " + u);

            transaction.begin(); // Iniciamos la transacion

            session.persist(u); // Persistimos ek objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void delete(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            System.out.println("Se borrara: " + u);

            transaction.begin(); // Iniciamos la transacion

            session.remove(u); // Eliminamos el objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void update(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            System.out.println("Se actualizara: " + u);

            transaction.begin(); // Iniciamos la transacion

            session.merge(u); // Actualizamos el objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public Usuario read(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {

            transaction.begin(); // Iniciamos la transacion

            u = session.get(u.getClass(), u.getIdUsuario());

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return u;
    }

    public List readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List urs = new ArrayList<>();

        try {

            transaction.begin(); // Iniciamos la transacion

            Query q = session.createQuery("from Usuario", Usuario.class);

            urs = (ArrayList<Usuario>) q.list();

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return urs;
    }

    public int validation(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario();

        List<Usuario> users = new ArrayList<>();

        try {
            transaction.begin();
            
            Query q = session.createQuery("from Usuario", Usuario.class);
            users = q.list();
            
            for(Usuario us : users){
                if(us.getUseName().equals(name) && us.getPassword().equals(password)){
                    return us.getIdUsuario();
                }
            }
            
            transaction.commit();
//            return u.getUseName().equals(name) && u.getPassword().equals(password);
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario();

        u.setIdUsuario(2);

        u = dao.read(u);

        System.out.println("Antes de actualizar: " + u);

//        u.setNombreUsuario("Matilda");
//        
//        dao.update(u);
//        
//        System.out.println("Despues de actualizar:" + dao.read(u));
    }
}
