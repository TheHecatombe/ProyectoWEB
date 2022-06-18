<%-- 
    Document   : listaProducto
    Created on : 12 jun 2022, 14:11:48
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%! ProductoDAO dao = new ProductoDAO(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Listado de productos</title>
    </head>
    <body>
        <%
            try{
                if((Boolean) session.getAttribute("login")){
                    out.println(dao.getNavbar());
        %>

        <h3 class="text-center mt-3">Listado de productos.</h3>

        <!--Boton para crear producto-->

        <div class="d-flex justify-content-end">
            <a href="agregarProducto.jsp" class="btn btn-outline-dark me-3">Nuevo producto</a>
        </div>

        <!--Creación de la tabla de productos--> 
        <div class="d-flex justify-content-center">
            <table class="mt-3 table table-striped table-dark" style="width: 95%">
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Stock</th>
                        <th scope="col">Detalles</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        List<Producto> lp = dao.readAll();
                    
                        if(lp.size() > 0){
                            for(int i = 0; i < lp.size(); i++){
                    %>
                    <tr>
                        <td><%= lp.get(i).getIdProducto()%></td>
                        <td><%= lp.get(i).getNombreProducto()%></td>
                        <td><%= lp.get(i).getDescripcionProducto()%></td>
                        <td>$<%= lp.get(i).getPrecioProducto()%></td>
                        <td><%= lp.get(i).getStockProducto()%></td>
                        <td><a href="detalleProducto.jsp?id=<%= lp.get(i).getIdProducto()%>" class="btn btn-outline-light">Detalles</a></td>
                        <td><a href="editarProducto.jsp?id=<%= lp.get(i).getIdProducto()%>" class="btn btn-outline-light">Editar</a></td>
                        <td><a href="eliminarProducto.jsp?id=<%= lp.get(i).getIdProducto()%>" class="btn btn-outline-light">Eliminar</a></td>
                    </tr>
                    <%
                            }
                    %>
                </tbody>
            </table>
        </div>
        <%
                    }else{
        %>
        <p>No hay productos registrados: <%= lp.size()%></p>
        <%
                    }
        %>            

        <%
                }else{
                    response.sendRedirect("../index.jsp");
                }
            } catch (Exception e){
                response.sendRedirect("../index.jsp");
            }
        %>

    </body>

</html>
