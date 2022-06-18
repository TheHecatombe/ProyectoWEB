<%-- 
    Document   : listaCliente
    Created on : 12 jun 2022, 19:09:05
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%! ClienteDAO dao = new ClienteDAO(); %>
<%! Cliente c = new Cliente(); %>
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
        <title>Listado de clientes</title>
    </head>
    <body>
        <% out.println(dao.getNavbar()); %>
        <h3 class="text-center mt-3">Listado de clientes</h3>

        <div class="d-flex justify-content-end">
            <a href="agregarCliente.jsp" class="btn btn-outline-dark me-3">Nuevo cliente</a>
        </div>

        <div class="d-flex justify-content-center">
            <table class="mt-3 table table-striped table-dark" style="width: 95%">
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido paterno</th>
                        <th scope="col">Apellido materno</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Detalles</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Cliente> clientes = new ArrayList<>();
                    
                        clientes = dao.readAll();
                    
                        for(Cliente cl : clientes){
                    
                    
                    %>

                    <tr>
                        <td><%= cl.getIdCliente()%></td>
                        <td><%= cl.getNombreCliente()%></td>
                        <td><%= cl.getPaternoCliente()%></td>
                        <td><%= cl.getMaternoCliente()%></td>
                        <td><%= cl.getTelefono()%></td>
                        <td><a href="detalleCliente.jsp?id=<%= cl.getIdCliente()%>" class="btn btn-outline-light">Detalles</a></td>
                        <td><a href="editarCliente.jsp?id=<%= cl.getIdCliente()%>" class="btn btn-outline-light">Editar</a></td>
                        <td><a href="eliminarCliente.jsp?id=<%= cl.getIdCliente()%>" class="btn btn-outline-light">Eliminar</a></td>
                    </tr>

                    <%
                        }

                        if(clientes.size() < 1){
                            out.println("<p>No hay clientes registrados</p>");
                        }
                    %>

                </tbody>
            </table>
        </div>
    </body>
</html>
