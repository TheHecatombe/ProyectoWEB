<%-- 
    Document   : addVenta
    Created on : 13 jun 2022, 21:21:36
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.lang.Exception" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.lang.Thread.*;" %>


<%! UsuarioDAO udao = new UsuarioDAO(); %>
<%! VentaDAO vdao = new VentaDAO(); %>
<%! ProductoDAO pdao = new ProductoDAO(); %>
<%! Usuario u = new Usuario(); %>
<%! Venta v = new Venta(); %>
<%! Producto p = new Producto(); %>
<!DOCTYPE html>
<html>
    <%
        try{
            Boolean login = (Boolean)session.getAttribute("login");
            if(!login){
                response.sendRedirect("../index.jsp");
            }

            }catch (Exception ex){
                response.sendRedirect("../index.jsp");
            }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadiendo venta...</title>
    </head>
    <body>
        <%
        
            List<Producto> productos = pdao.readAll();
            
            for(Producto ps : productos){
                int cantidad = Integer.parseInt(request.getParameter("txt"+ps.getIdProducto()));
                
                System.out.println(ps);
                
                for(int j = 0; j < cantidad; j++){
                    productos.add(new Producto(ps.getIdProducto(), ps.getNombreProducto(), ps.getDescripcionProducto(), ps.getPrecioProducto(), ps.getStockProducto()));
                }
                
                ps.setStockProducto(ps.getStockProducto() - cantidad);
                
                pdao.update(ps);
                
                System.out.println("Ok Stock");
            }
            v.setProductos(productos);
            v.setFechaVenta(new Date());

            int idVendedor = (int)session.getAttribute("userId");
            
            if(idVendedor != -1){
                u.setIdUsuario(idVendedor);
                u = udao.read(u);

                v.setUsuario(u);

                vdao.create(v);
            }

        %>
    </body>
</html>
