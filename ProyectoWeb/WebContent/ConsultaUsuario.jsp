<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "/header.jsp" %>

</head>
<%
System.out.println(sesion.getAttribute("optConsultaCursoInfoCurso"));
if(sesion.getAttribute("optConsultaUsuario") == null){	
	sesion.setAttribute("optConsultaUsuario", "0");
}

%>
<body>
	<h1 align="center"> Consulta Usuario </h1>
	<%if(sesion.getAttribute("optConsultaUsuario").toString().equals("0")) {%>
		<div class="form-row" id="tabla">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Usuario</th>
			      <th scope="col">Correo</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Buscar</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      
			      <td>Rodri</td>
			      <td>rodri@hot</td>
			      
			      <td width="20%"><a href="http://www.google.com">Link1 goes here</a></td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<%} %>
<%@include file = "/footer.jsp" %>
</body>
</html>