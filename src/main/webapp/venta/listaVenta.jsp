<%-- 
    Document   : listaVenta
    Created on : 13 jun 2022, 19:37:04
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%! VentaDAO dao = new VentaDAO(); %>
<%! Venta v = new Venta(); %>
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
        <title>Listado de ventas</title>
    </head>
    <body>
        <% out.println(dao.getNavbar()); %>
        <h3 class="text-center mt-3">Listado de ventas</h3>

        <div class="d-flex justify-content-end">
            <a href="listaVenta.jsp" class="btn btn-outline-dark me-3">Nueva venta</a>
        </div>

        <div class="d-flex justify-content-center">
            <table class="mt-3 table table-striped table-dark" style="width: 95%">
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>
                        <th scope="col">Fecha de venta</th>
                        <th scope="col">Vendedor</th>
                        <th scope="col">Detalles</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Venta> ventas = new ArrayList<>();
                    
                        ventas = dao.readAll();
                    
                        for(Venta vs : ventas){
                    
                    
                    %>

                    <tr>
                        <td><%= vs.getIdVenta()%></td>
                        <td><%= vs.getFechaVenta()%></td>
                        <td><%= vs.getUsuario().getNombreUsuario()%> <%= vs.getUsuario().getPaternoUsuario()%> <%= vs.getUsuario().getMaternoUsuario()%></td>
                        <td><a href="detalleCliente.jsp?id=<%= vs.getIdVenta()%>" class="btn btn-outline-light">Detalles</a></td>
                        <td><a href="editarCliente.jsp?id=<%= vs.getIdVenta()%>" class="btn btn-outline-light">Editar</a></td>
                        <td><a href="eliminarCliente.jsp?id=<%= vs.getIdVenta()%>" class="btn btn-outline-light">Eliminar</a></td>
                    </tr>

                    <%
                        }

                        if(ventas.size() < 1){
                            out.println("<p>No hay clientes registrados</p>");
                        }
                    %>

                </tbody>
            </table>
        </div>
    </body>
</html>
