<%@page import="publicadores.DtEdicion"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Consultar la Informacion de una Edicion</title>
</head>
<body>
<% 
if(session.getAttribute("optConsultaEdicionInfoEdicion") == null){
	session.setAttribute("optConsultaEdicionInfoEdicion", request.getParameter("optConsultaEdicionInfoEdicion"));
}
ArrayList<String> cursos = (ArrayList) session.getAttribute("cursosInfoEdicion");
ArrayList<String> ediciones = (ArrayList) session.getAttribute("edicionesInfoEdicion");
boolean esInstitutoInfoEdicion = session.getAttribute("esInstitutoEd") != null;
boolean esCategoriaInfoEdicion = session.getAttribute("esCategoriaEd") != null;
String cursoConsultaEdicion = (String) session.getAttribute("cursoConsultaEdicion");
DtEdicion infoEdicion = (DtEdicion) session.getAttribute("infoEdicion");
String edicionConsultaEdicion = (String) sesion.getAttribute("edicionConsultaEdicion");

if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("0")) {%>
<h1 align="center"> Ingrese el Instituto </h1>
<br><br>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
		<div class="MyDiv" id="nombres" style="margin-left:15%">
	      <input class="form-check-input" type="checkbox" id="esInstitutoInfoEdicion" name="esInstitutoInfoEdicion" checked>
	      <label class="form-check-label" for="checkInstituto" style="font-size: 150%">Es Instituto</label>
	    </div>
	</div>
	<div class="form-row" id="nombres">
		<div class="MyDiv" style="margin-left:15%">
	      <input class="form-check-input" type="checkbox" id="esCategoriaInfoEdicion" name="esCategoriaInfoEdicion">
	      <label class="form-check-label" for="checkCategoria" style="font-size: 150%">Es Categoria</label>
	    </div>
	</div>
	<br><br>
		<div class="MyDiv">
	      <input type="text" name="InsCatEd" class="form-control" id="InsCatEd" style="display:block; margin:auto; width:80%;">
	    </div>
	    <br>
	    <div class="MyDiv">
      		<button type="submit" class="btn btn-primary" style="display:block; margin:auto;">Buscar Cursos</button> 
      	</div>
</form>
<%} else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("1")) {%>
<h1 align="center"> Seleccione el Curso </h1>
<br><br>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>"> -->
		<div align="center" class="form-group col-md-6">
	      <label for="inputCurso">Curso</label>
      	<select id="inputCurso" name="cursoInfoEdicion" class="selectpicker" required>
        	<option></option>
        	<%for(String c: cursos){ %>
        	<option value="<%= c %>"><%= c %></option>
        	<%} %>
      	</select>
	    </div>
	    <button type="submit" class="btn btn-primary" style="display:block; margin:auto;">Buscar Ediciones</button>
	</div>
</form>
<%} else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("2")) { %>
<h1 align="center"> Seleccione la Edicion </h1>
<br><br>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>"> -->
		<div align="center" class="form-group col-md-6">
	      <label for="inputEdicion">Edicion</label>
	      <select id="inputEdicion" name="edicion" class="selectpicker" required>
	        <option></option>
	        <%for(String e: ediciones){ %>
	        <option value="<%= e %>"><%= e %></option>
	        <%} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary" style="display:block; margin:auto;">Mostrar Informacion</button>
	</div>
</form>
<%}else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("3")) {%>
<h1 align="center"> Informacion de <%= edicionConsultaEdicion %> </h1>
<br><br>
<form>
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>"> -->
	<table class="table">
	  <tbody>
	    <tr>
	      <th scope="row">Nombre de la Edicion</th>
	      <td><%= infoEdicion.getNombre() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Inicio</th>
	      <td><%= infoEdicion.getFechaI().getDia() + "/" + infoEdicion.getFechaI().getMes() + "/" + infoEdicion.getFechaI().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Fin</th>
	      <td><%= infoEdicion.getFechaF().getDia() + "/" + infoEdicion.getFechaF().getMes() + "/" + infoEdicion.getFechaF().getAnio() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Tiene Cupos</th>
	      <% if(infoEdicion.isTieneCupos()){ %>
	      <td> Si </td>
	      <%} else { %>
	      <td> No </td>
	      <%} %>
	    </tr>
	    <tr>
	      <th scope="row">Cupos(Si la edicion no tiene cupos se imprime 0)</th>
	      <td><%= infoEdicion.getCupo() %></td>
	    </tr>
	    <tr>
	      <th scope="row">Fecha de Publicacion</th>
	      <td><%= infoEdicion.getFechaPub().getDia() + "/" + infoEdicion.getFechaPub().getMes() + "/" + infoEdicion.getFechaPub().getAnio() %></td>
	    </tr>
	  </tbody>
	</table>
	</div>
</form>
<% } %>  
<%@include file = "/footer.jsp" %>
</body>
</html>