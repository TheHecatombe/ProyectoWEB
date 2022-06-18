<%-- 
    Document   : addCliente
    Created on : 12 jun 2022, 19:52:14
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>


<%! ClienteDAO dao = new ClienteDAO();%>
<%! Cliente c = new Cliente();%>

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
        <title>Añadiendo cliente...</title>
    </head>
    <body>
        <%
            c.setNombreCliente(request.getParameter("txtNombreCliente"));
            c.setPaternoCliente(request.getParameter("txtPaternoCliente"));
            c.setMaternoCliente(request.getParameter("txtMaternoCliente"));
            c.setTelefono(request.getParameter("txtTelefonoCliente"));
            
            dao.create(c);
            
            response.sendRedirect("listaCliente.jsp");
        %>
    </body>
</html>
