<%@page import="datatypes.DtEdicionCompleta"%>
<%@page import="datatypes.DtInscripcionEd"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Listar estudiantes aceptados a Edicion</title>
</head>
<body>
<% 
if(session.getAttribute("opAceptadosEdicion") == null){
	session.setAttribute("opAceptadosEdicion", request.getParameter("opAceptadosEdicion"));
}
ArrayList<String> cursos = (ArrayList) session.getAttribute("cursosAceptados");
ArrayList<String> ediciones = (ArrayList) session.getAttribute("edicionesAceptados");
//String cursoConsultaEdicion = (String) session.getAttribute("cursoConsultaEdicion");
DtEdicionCompleta infoEdicionAceptados = (DtEdicionCompleta) session.getAttribute("infoFinalAceptados");
//String edicionConsultaEdicion = (String) sesion.getAttribute("edicionConsultaEdicion");

if(session.getAttribute("opAceptadosEdicion").toString().equals("0")) {%>
<h1 align="left"> Ingrese el Instituto </h1>
<br><br>
<form action="ListarAceptadosEdicion" method="post">
	<br><br>
	<div class="form-row">
		<div class="form-group col-md-5">
	      <input type="text" name="institutoAceptados" class="form-control" id="institutoAceptados" required>
	    </div>
      	<button type="submit" class="btn btn-primary">Buscar Cursos</button> 
	</div>
</form>
<%} else if(session.getAttribute("opAceptadosEdicion").toString().equals("1")) {%>
<h1 align="left"> Seleccione el Curso </h1>
<br><br>
<form action="ListarAceptadosEdicion" method="post">
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="cursoSelectAceptados">Curso</label>
      	<select id="cursoSelectAceptados" name="cursoSelectAceptados" class="selectpicker" required>
        	<%for(String c: cursos){ %>
        	<option value="<%= c %>"><%= c %></option>
        	<%} %>
      	</select>
	    </div>
	    <button type="submit" class="btn btn-primary">Buscar Ediciones</button>
	</div>
</form>
<%} else if(session.getAttribute("opAceptadosEdicion").toString().equals("2")) {
%>
<h1 align="left"> Seleccione la Edicion </h1>
<br><br>
<form action="ListarAceptadosEdicion" method="post">
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="edicionSelectAceptados">Edicion</label>
	      <select id="edicionSelectAceptados" name="edicionSelectAceptados" class="selectpicker" required>
	        <%for(String e: ediciones){ %>
	        <option value="<%= e %>"><%= e %></option>
	        <%} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Mostrar Informacion</button>
	</div>
</form>
<%}else if(session.getAttribute("opAceptadosEdicion").toString().equals("3")) {%>
<h1 align="left"> Informacion de Edición e inscriptos aceptados  </h1>
<br><br>
<form>
	<div class="form-row">
	<table class="table">
	  <tbody>
	    <tr>
	      <th scope="row">Nombre de la Edicion</th>
	      <td><%= infoEdicionAceptados.getNombre() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Inicio</th>
	      <td><%= infoEdicionAceptados.getFechaI().getDia() + "/" + infoEdicionAceptados.getFechaI().getMes() + "/" + infoEdicionAceptados.getFechaI().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Fin</th>
	      <td><%= infoEdicionAceptados.getFechaF().getDia() + "/" + infoEdicionAceptados.getFechaF().getMes() + "/" + infoEdicionAceptados.getFechaF().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Tiene Cupos</th>
	      <% if(infoEdicionAceptados.isTieneCupos()){ %>
	      <td> Si </td>
	      <%} else { %>
	      <td> No </td>
	      <%} %>
	    </tr>
	    <tr>
	      <th scope="row">Cupos(Si la edicion no tiene cupos se imprime 0)</th>
	      <td><%= infoEdicionAceptados.getCupo() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Publicacion</th>
	      <td><%= infoEdicionAceptados.getFechaPub().getDia() + "/" + infoEdicionAceptados.getFechaPub().getMes() + "/" + infoEdicionAceptados.getFechaPub().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row" rowspan="1">Estudiantes con Inscripcion en estado Aceptada</th>
	    </tr>
	  </tbody>
	</table>
	<table class="table">
	  <tbody>
		<% if(infoEdicionAceptados.getInscripciones().isEmpty()){ %>
		<tr>
	      <td> No hay ningún estudiante con inscripción aceptada </td>
	    </tr>
	    <%} else { %>
	    <%for(DtInscripcionEd dted: infoEdicionAceptados.getInscripciones()){ %>
		<tr>
	      <td>Nombre: <%=dted.getEstudiante().getNick()%> | Fecha de Inscripcion: <%= dted.getFecha().getDia() + "/" + dted.getFecha().getMes() + "/" + dted.getFecha().getAnio() %></td>
	    </tr>  
	      <%} %>
	    <%} %>
	  </tbody>     
	</table>

	</div>
</form>
<% } %>  
<%@include file = "/footer.jsp" %>
</body>
</html>