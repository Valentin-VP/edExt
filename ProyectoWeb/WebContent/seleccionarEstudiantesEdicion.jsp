<%@page import="datatypes.DtEdicionCompleta"%>
<%@page import="datatypes.DtInscripcionEd"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "/header.jsp" %>
<title>Seleccionar estudiantes</title>
</head>
<body>
<% 
if(session.getAttribute("opSeleccionarEstudiantes") == null){
	session.setAttribute("opSeleccionarEstudiantes", request.getParameter("opSeleccionarEstudiantes"));
}
ArrayList<String> cursos = (ArrayList) session.getAttribute("cursos");
DtEdicionCompleta edicion = (DtEdicionCompleta) session.getAttribute("edicionCompleta");
//String cursoConsultaEdicion = (String) session.getAttribute("cursoConsultaEdicion");
//DtEdicionCompleta infoEdicionAceptados = (DtEdicionCompleta) session.getAttribute("infoFinalAceptados");
//String edicionConsultaEdicion = (String) sesion.getAttribute("edicionConsultaEdicion");

if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("0")) {%>
<h1 align="left"> Ingrese el Instituto </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
	<br><br>
	<div class="form-row">
		<div class="form-group col-md-5">
	      <input type="text" name="institutoSeleccionado" class="form-control" id="institutoSeleccionado">
	    </div>
      	<button type="submit" class="btn btn-primary">Buscar Cursos</button> 
	</div>
</form>
<%} else if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("1")) {%>
<h1 align="left"> Seleccione el Curso </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="cursoSelect">Curso</label>
      	<select id="cursoSelect" name="cursoSelect" class="selectpicker">
        	<option selected disabled>Choose...</option>
        	<%for(String c: cursos){ %>
        	<option value="<%= c %>"><%= c %></option>
        	<%} %>
      	</select>
	    </div>
	    <button type="submit" class="btn btn-primary">Mostrar Edicion Vigente</button>
	</div>
</form>
<%} else if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("2")) {
%>
<h1 align="left"> Seleccione la Edicion </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="edicionSelect">Edicion</label>
	      <select id="edicionSelect" name="edicionSelect" class="selectpicker">
	        <option selected disabled>Choose...</option>
	        <%//for(String e: ediciones){ %>
	        <option value="<%= edicion.getNombre() %>"><%= edicion.getNombre() %></option>
	        <%//} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Mostrar Informacion</button>
	</div>
</form>
<%}else if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("3")) {%>
<h1 align="left"> Informacion de Estudiantes inscriptos a la edicion  </h1>
<br><br>
<form>
	<div class="form-row">
	<table class="table">
	  <tbody>
	    <tr>
	      <th scope="row">Nombre de la Edicion</th>
	      <td><%= edicion.getNombre() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Inicio</th>
	      <td><%= edicion.getFechaI().getDia() + "/" + edicion.getFechaI().getMes() + "/" + edicion.getFechaI().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Fin</th>
	      <td><%= edicion.getFechaF().getDia() + "/" + edicion.getFechaF().getMes() + "/" + edicion.getFechaF().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Tiene Cupos</th>
	      <% if(edicion.isTieneCupos()){ %>
	      <td> Si </td>
	      <%} else { %>
	      <td> No </td>
	      <%} %>
	    </tr>
	    <tr>
	      <th scope="row">Cupos(Si la edicion no tiene cupos se imprime 0)</th>
	      <td><%= edicion.getCupo() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Publicacion</th>
	      <td><%= edicion.getFechaPub().getDia() + "/" + edicion.getFechaPub().getMes() + "/" + edicion.getFechaPub().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row" rowspan="1">Estudiantes con Inscripcion en estado Aceptada</th>
	    </tr>
	  </tbody>
	</table>
	<table class="table">
	  <tbody>
		<% if(edicion.getInscripciones().isEmpty()){ %>
		<tr>
	      <td> No hay ningún estudiante con inscripción aceptada </td>
	    </tr>
	    <%} else { %>
	    <%for(DtInscripcionEd dted: edicion.getInscripciones()){ %>
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