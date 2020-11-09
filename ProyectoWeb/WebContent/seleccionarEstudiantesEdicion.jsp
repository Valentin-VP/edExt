<%@page import="publicadores.DtEdicionCompleta"%>
<%@page import="publicadores.DtInscripcionEd"%>
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
ArrayList<String> cursos = (ArrayList) session.getAttribute("cursosSeleccionarEstudiantes");
DtEdicionCompleta edicion = (DtEdicionCompleta) session.getAttribute("edicionCompletaSeleccionarEstudiantes");
ArrayList<DtInscripcionEd> inscripciones = (ArrayList) session.getAttribute("inscripcionesEstudiantes");

if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("0")) {%>
<h1 align="left"> Ingrese el Instituto </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
	<br><br>
	<div class="form-row">
		<div class="form-group col-md-5">
	      <input type="text" name="institutoSeleccionado" class="form-control" id="institutoSeleccionado" required>
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
      	<select id="cursoSeleccionarEstudiantes" name="cursoSeleccionarEstudiantes" class="selectpicker" required>
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
<h1 align="left"> Seleccione el orden de los estudiantes </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="edicionSelect">Edicion Vigente</label>
	      <select id="edicionSelect" name="edicionSelect" class="selectpicker" required>
	        <option value="<%= edicion.getNombre() %>"><%= edicion.getNombre() %></option>
	      </select>
	    </div>
	</div>
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="ordenarEstudiantes">Ordenar</label>
	      <select id="ordenarEstudiantes" name="ordenarEstudiantes" class="selectpicker" required>
	        <option value="no ordenar">no ordenar</option>
	        <option value="fecha">fecha</option>
	        <option value="prioridad">prioridad</option>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Mostrar Estudiantes de Edicion Vigente</button>
	</div>
</form>
<%}else if(session.getAttribute("opSeleccionarEstudiantes").toString().equals("3")) {%>
<h1 align="left"> Informacion de Estudiantes inscriptos a la edicion </h1>
<br><br>
<form action="SeleccionarEstudiantesEdicion" method="post">
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
	      <th scope="row" rowspan="1">Estudiantes con Inscripcion realizada</th>
	    </tr>
	  </tbody>
	</table>
	<table class="table">
	  <tbody>
		<% if(edicion.getInscripciones().length == 0){ %>
		<tr>
	      <td> No hay ningún estudiante inscripto a la Edicion </td>
	    </tr>
	    <%} else { %>
	    <%for(DtInscripcionEd dted: edicion.getInscripciones()){ %>
		<tr>
	      <td>Nick: <%=dted.getEstudiante().getNick()%> Estado: <%=dted.getEstado()%> | Fecha de Inscripcion: <%= dted.getFecha().getDia() + "/" + dted.getFecha().getMes() + "/" + dted.getFecha().getAnio() %></td>
	    </tr>  
	      <%} %>
	    <%} %>
	  </tbody>     
	</table>
	</div>
<!-- </form> -->
<!-- <form action="SeleccionarEstudiantesEdicion" method="post"> -->
	<div class="form-row">
		<div align="left" class="form-group col-md-5">
	      <label for="cursoSelect">Nick</label>
      	<select id="estudianteSeleccionado" name="estudianteSeleccionado" class="selectpicker" required>
        	<%for(DtInscripcionEd dted: edicion.getInscripciones()){ %>
        	<option value="<%= dted.getEstudiante().getNick() %>"><%= dted.getEstudiante().getNick() %></option>
        	<%} %>
      	</select>
	    </div>
	    <div align="right" class="form-group col-md-5">
	      <label for="cursoSelect">Estado</label>
      	<select id="estadoSeleccionado" name="estadoSeleccionado" class="selectpicker" required>
        	<option value="Aceptada">Aceptada</option>
        	<option value="Rechazada">Rechazada</option>
      	</select>
	    </div>
	    <button class="btn btn-primary" type="button" onclick="actualizarEstudiante();">Actualizar Datos</button>
	</div>
	<h3 id="result"></h3>
	<div class="form-row">
	     <button type="submit" class="btn btn-primary">Confirmar</button>
	</div>
</form>
<% } %>
<script type="text/javascript">
function actualizarEstudiante() {
	var nickestudiante=$("#estudianteSeleccionado :selected").text();
 	var estadoestudiante=$("#estadoSeleccionado :selected").val();
	$.ajax({ // Request Asincronica AJAX
		url: 'SeleccionarEstudiantesEdicion', // Serverlet
		method: 'POST',					// Metodo
		data: {nickestudiante : nickestudiante,
				estadoestudiante : estadoestudiante}, // los datos que voy a mandar, nombre del atributo : el valor
		success: function(resultText){ // si sale bien el request
			$('#result').html(resultText); // muestro los datos en el h3 usando su id para identificarlo
		},
		error: function(jqXHR, exception){ // si da error el request
		console.log('Error occured!!'); // imprimo en la consola del navegador
		}
	});
}
</script>

<%@include file = "/footer.jsp" %>
</body>
</html>