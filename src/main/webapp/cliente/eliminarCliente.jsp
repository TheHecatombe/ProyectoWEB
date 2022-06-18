<%-- 
    Document   : eliminarCliente
    Created on : 12 jun 2022, 21:32:42
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
        <title>Eliminando cliente...</title>
    </head>
    <body>
        <%
            c.setIdCliente(Integer.parseInt(request.getParameter("id")));
            
            dao.delete(c);
            
            response.sendRedirect("listaCliente.jsp");
        %>
    </body>
</html>
