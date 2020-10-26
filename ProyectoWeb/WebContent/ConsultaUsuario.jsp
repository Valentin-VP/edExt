<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatypes.DtUsuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "/header.jsp" %>

</head>
<%
if(sesion.getAttribute("optConsultaUsuario") == null){	
	sesion.setAttribute("optConsultaUsuario", "0");
}
ArrayList<DtUsuario> usuarios = (ArrayList) sesion.getAttribute("usuariosConsultaUsuario");
if(usuarios == null){
	usuarios = new ArrayList<DtUsuario>();
}
%>
<body>
	<h1 align="center"> Consulta Usuario </h1>
	<%if(sesion.getAttribute("optConsultaUsuario").toString().equals("0")){%>
		<div class="container" align=center>
		  <nav class="navbar navbar-expand-sm white justify-content-center" >
		    <form action="ConsultaUsuario" method="post" >
				<div class="form-row" align=center>
					<button class="btn btn-danger" id="botonCargar" type="submit" >Cargar Usuarios</button>
				</div>
			</form>
		  </nav>
		</div>
	<%}else{%>
		<div class="container" align=center>
		  <nav class="navbar navbar-expand-sm white justify-content-center" >
		    <form action="ConsultaUsuario" method="post" >
				<div class="form-row" align=center>
					<button class="btn btn-danger" id="botonCargar" type="submit" disabled>Cargar Usuarios</button>
				</div>
			</form>
		  </nav>
		</div>
	<%} %>
	
	<%if(!sesion.getAttribute("optConsultaUsuario").toString().equals("0")) { %>
			<div class="form-row" id="tabla">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Nick</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Apellido</th>
				      <th scope="col">Buscar</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<%for(DtUsuario u: usuarios ){  %>
					    <tr>
					      <td><%=u.getNick() %></td>
					      <td><%=u.getNombre() %></td>
					      <td><%=u.getApellido() %></td>
					      <td class="btn btn-danger" width="20%"><a href="PerfilUsuario?nickConsultaUsuario=<%= u.getNick() %>">Perfil</a></td>
					    </tr>
					<%} %>
				  </tbody>
				</table>
			</div>
	<%} %>
<%@include file = "/footer.jsp" %>
</body>
</html>