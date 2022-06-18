<%-- 
    Document   : agregaVenta
    Created on : 13 jun 2022, 20:04:08
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.proyectomanicure.modelo.dao.*" %>
<%@page import="com.ipn.mx.proyectomanicure.modelo.entidades.*" %>
<%@page import="java.lang.Exception" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>


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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Nueva venta</title>
    </head>
    <body>
        <% out.println(vdao.getNavbar()); %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 40rem">
                <div class="card-header text-center">
                    <h3>Nueva venta</h3>
                </div>

                <%
                    int idVendedor = -1;
                    try{
                        idVendedor = (int)session.getAttribute("userId");    
                    }catch (Exception e){
                        out.println("<h5> " + e + " </h5>");
                    }
                    
                    if(idVendedor != -1){
                        u.setIdUsuario(idVendedor);
                        u = udao.read(u);
                    }
//                %>

                <div class="card-body">
                    <form action="../VentaServlet" method="post">

                        <div>
                            <input type="hidden" class="form-control" id="accion" name="accion" value="addVenta">
                        </div>

                        <div class="mb-3">
                            <label for="txtUsuario" class="form-label">Vendedor</label>
                            <input type="text" class="form-control" id="txtUsuario" name="txtUsuario" value="<%= u.getNombreUsuario()%> <%= u.getPaternoUsuario()%> <%= u.getMaternoUsuario()%>" disabled>
                        </div>

                        <h4>Cantidad por producto</h4>

                        <%
                            List<Producto> productos = pdao.readAll();
                            
                            for(Producto ps : productos){
                                
                            
                        %>
                        <div class="input-group mt-3 mb-3">
                            <span class="input-group-text" id="span_<%= ps.getIdProducto()%>"><%= ps.getNombreProducto()%></span>
                            <input class="form-control" type="number" id="txt<%= ps.getIdProducto()%>" name="txt<%= ps.getIdProducto()%>" max="<%= ps.getStockProducto()%>" min="0" value="0">
                        </div>
                        <%
                            }
                        %>

                        <div class="d-flex justify-content-between mt-3">
                            <button type="submit" value="submit" class="btn btn-outline-dark">Agregar nueva venta</button>
                            <a href="listaVenta.jsp" class="btn btn-outline-danger">Cancelar</a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
