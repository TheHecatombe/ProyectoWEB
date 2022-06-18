<%-- 
    Document   : editarCliente
    Created on : 12 jun 2022, 22:11:17
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Editar cliente</title>
    </head>
    <body>
        <% out.println(dao.getNavbar());
        
            c.setIdCliente(Integer.parseInt(request.getParameter("id")));
            c = dao.read(c);
        
        %>
        <div class="d-flex justify-content-center mt-5">
            <div class="card" style="width: 40rem">
                <div class="card-header text-center">
                    <h3>Editar cliente</h3>
                </div>
                <div class="card-body">
                    <form action="mergeCliente.jsp">
                        <div class="mb-3">
                            <label for="txtIdentificador" class="form-label">Identificador</label>
                            <input type="text" class="form-control" id="txtIdentificador" name="txtIdentificador" disabled="true" value="<%= c.getIdCliente()%>">
                        </div>
                        <div class="mb-3">
                            <label for="id" class="form-label">Identificador</label>
                            <input type="hidden" class="form-control" id="id" name="id" value="<%= c.getIdCliente()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtNombreCliente" class="form-label">Nombre del cliente</label>
                            <input type="text" class="form-control" id="txtNombreCliente" name="txtNombreCliente" value="<%= c.getNombreCliente()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtPaternoCliente" class="form-label">Apellido paterno del cliente</label>
                            <input type="text" class="form-control" id="txtPaternoCliente" name="txtPaternoCliente" value="<%= c.getPaternoCliente()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtMaternoCliente" class="form-label">Apellido materno del cliente</label>
                            <input type="text" class="form-control" id="txtMaternoCliente" name="txtMaternoCliente" value="<%= c.getMaternoCliente()%>">
                        </div>
                        <div class="mb-3">
                            <label for="txtTelefonoCliente" class="form-label">Teléfono del cliente</label>
                            <input type="number" class="form-control" id="txtTelefonoCliente" name="txtTelefonoCliente" step=1 maxlength="10" minlength="10" value="<%= c.getTelefono()%>">
                        </div>

                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-outline-dark">Editar cliente</button>
                            <a href="listaCliente.jsp" class="btn btn-outline-danger">Cancelar</a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
