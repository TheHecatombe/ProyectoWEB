<%-- 
    Document   : agregarProducto
    Created on : 12 jun 2022, 16:51:16
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Editar producto</title>
    </head>
    <body>
        <%
            out.println(dao.getNavbar());
            
            p.setIdProducto(Integer.parseInt(request.getParameter("id")));
            
            p = dao.read(p);
        %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 40rem">
                <div class="card-header text-center">
                    <h3>Editar producto</h3>
                </div>
                <div class="card-body">
                    <form action="mergeProducto.jsp">
                        <div class="mb-3">
                            <label for="txtIdentificadorProducto" class="form-label">Identificador del producto</label>
                            <input type="text" class="form-control" id="txtIdentificadorProducto" name="txtIdentificadorProducto" value="<%= p.getIdProducto()%>" disabled=true>
                        </div>
                        <div class="mb-3">
                            <input type="hidden" class="form-control" id="id" name="id" value="<%= p.getIdProducto()%>" >
                        </div>
                        <div class="mb-3">
                            <label for="txtNombreProducto" class="form-label">Nombre del producto</label>
                            <input type="text" class="form-control" id="txtnombreProducto" name="txtnombreProducto" value="<%= p.getNombreProducto()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtDescripcionProducto" class="form-label">Descripción del producto</label>
                            <input type="text" class="form-control" id="txtdescripcionProducto" name="txtdescripcionProducto" value="<%= p.getDescripcionProducto()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtPrecioProducto" class="form-label">Precio</label>
                            <input type="number" class="form-control" id="txtPrecioProducto" name="txtPrecioProducto" step=0.01 min=0 value="<%= p.getPrecioProducto()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtStockProducto" class="form-label">Stock</label>
                            <input type="number" class="form-control" id="txtStockProducto" name="txtStockProducto" min=0 value="<%= p.getStockProducto()%>">
                        </div>

                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-outline-dark">Editar producto</button>
                            <a href="listaProducto.jsp" class="btn btn-outline-danger">Cancelar</a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
