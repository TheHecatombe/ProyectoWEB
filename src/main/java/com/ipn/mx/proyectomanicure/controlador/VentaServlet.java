/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.proyectomanicure.controlador;

import com.ipn.mx.proyectomanicure.modelo.dao.ProductoDAO;
import com.ipn.mx.proyectomanicure.modelo.dao.UsuarioDAO;
import com.ipn.mx.proyectomanicure.modelo.dao.VentaDAO;
import com.ipn.mx.proyectomanicure.modelo.entidades.Producto;
import com.ipn.mx.proyectomanicure.modelo.entidades.Usuario;
import com.ipn.mx.proyectomanicure.modelo.entidades.Venta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author jonathan
 */
@WebServlet(name = "VentaServlet", value = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        System.out.println("Parametro: " + accion);

        switch (accion) {
            case "addVenta":
                addVenta(request, response);
                break;
//            default:
//                errorPage(request, response);
//                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = new Usuario();

        ProductoDAO pdao = new ProductoDAO();
        Producto p = new Producto();

        VentaDAO vdao = new VentaDAO();
        Venta v = new Venta();

        // Se crea la venta en blanco

        v.setFechaVenta(new Date());

        int idVendedor = (int) request.getSession().getAttribute("userId");

        u.setIdUsuario(idVendedor);
        u = udao.read(u);

        v.setUsuario(u);

        vdao.create(v);
        
        // Se actualizan los stock de los productos
        
        List<Producto> productos = pdao.readAll();

        for (int i = 0; i < productos.size(); i++) {

            int cantidad = Integer.parseInt(request.getParameter("txt" + productos.get(i).getIdProducto()));

            for (int j = 0; j < cantidad; j++) {
                
                // Se añaden los productos vendidos a la venta-
                v.getProductos().add(new Producto(productos.get(i).getIdProducto(), productos.get(i).getNombreProducto(), productos.get(i).getDescripcionProducto(), productos.get(i).getPrecioProducto(), productos.get(i).getStockProducto()));

                productos.get(i).setStockProducto(productos.get(i).getStockProducto() - 1);

                pdao.update(productos.get(i));
            }

        }
        
        
        // Se actualiza la venta con los productos vendidos.
        
//        List<Venta> ventas = vdao.readAll();
        
//        v.setIdVenta(ventas.get(ventas.size() - 1).getIdVenta());
        
        vdao.update(v);
        
        response.sendRedirect("venta/listaVenta.jsp");

    }
}
