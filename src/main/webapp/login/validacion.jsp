<%-- 
    Document   : validacion
    Created on : 12 jun 2022, 13:22:26
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion</title>
    </head>
    <body>
        <%
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            
            UsuarioDAO dao = new UsuarioDAO();
            int idUsuario = dao.validation(user, pass);
            
            try{
                if(idUsuario != -1){
                    session.setAttribute("login", true);
                    session.setAttribute("userId", idUsuario);
                } else {
                    session.setAttribute("login", false);
                    session.setAttribute("userId", -1);
                }
            }
            catch(Exception ex){
                out.println("<h1>Ha ocurrido un error</h1>");
                out.println("<>" + ex + "</p>");
            }
        %>
    </body>
    <%
        response.sendRedirect("../index.jsp");
    %>
</html>
