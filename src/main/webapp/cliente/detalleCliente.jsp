<%-- 
    Document   : detalleCliente
    Created on : 12 jun 2022, 21:54:48
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<jsp:declaration>ClienteDAO dao = new ClienteDAO();</jsp:declaration>
<jsp:declaration>Cliente c = new Cliente();</jsp:declaration>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Detalle cliente</title>
    </head>
    <body>
        <%  
            out.println(dao.getNavbar());
            c.setIdCliente(Integer.parseInt(request.getParameter("id")));
            c = dao.read(c);
        %>
        <h3 class="text-center mt-3">Detalle del cliente.</h3>
        <div class="mt-5 d-flex justify-content-center">
            <div class="card" style="width: 18rem">
                <div class="card-body">
                    <h5><%= c.getNombreCliente()%> <%= c.getPaternoCliente()%> <%= c.getMaternoCliente()%></h5>
                    <p><%= c.getTelefono()%></p>
                </div>
            </div>
        </div>
    </body>
</html>
