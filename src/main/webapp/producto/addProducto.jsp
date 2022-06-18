<%-- 
    Document   : addProducto
    Created on : 12 jun 2022, 17:11:08
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>


<%! ProductoDAO dao = new ProductoDAO();%>
<%! Producto p = new Producto();%>
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
        <title>Añadiendo producto...</title>
    </head>
    <body>
        <%
            p.setNombreProducto(request.getParameter("txtnombreProducto"));
            p.setDescripcionProducto(request.getParameter("txtdescripcionProducto"));
            p.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecioProducto")));
            p.setStockProducto(Integer.parseInt(request.getParameter("txtStockProducto")));
            
            dao.create(p);
            
            response.sendRedirect("listaProducto.jsp");
        %>
    </body>
</html>
