<%@page import="datatypes.DtEdicion"%>
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
//String edicionConsultaEdicion = (String) sesion.getAttribute("edicionConsultaEdicion");

if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("0")) {%>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>">
	<input type="text" name="esInstitutoInfoEdicion" value="<%=esInstitutoInfoEdicion%>">
  	<input type="text" name="esCategoriaInfoEdicion" value="<%=esCategoriaInfoEdicion%>"> -->
		<div class="form-check">
	      <input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstitutoInfoEdicion" checked>
	      <label class="form-check-label" for="checkInstituto">Es Instituto</label>
	    </div>
	    <div class="form-check col-md-2">
	      <input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoriaInfoEdicion">
	      <label class="form-check-label" for="checkCategoria">Es Categoria</label>
	    </div>
	</div>
	<br>
	<div class="form-row">
		<div class="form-group col-md-3">
	      <input type="text" name="InsCatEd" class="form-control" id="InsCatEd">
	    </div>
      	<button type="submit" class="btn btn-primary">Buscar Cursos</button> 
	</div>
</form>
<%} else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("1")) {%>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>"> -->
		<div class="form-group col-md-6">
	      <label for="inputCurso">Curso</label>
	      <select id="inputCurso" name="cursoInfoEdicion" class="selectpicker">
	        <option selected disabled>Choose...</option>
	        <%for(String c: cursos){ %>
	        <option value="<%= c %>"><%= c %></option>
	        <%} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Buscar Ediciones</button>
	</div>
</form>
<%} else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("2")) { %>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<!-- <input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>"> -->
		<div class="form-group col-md-6">
	      <label for="inputEdicion">Edicion</label>
	      <select id="inputEdicion" name="edicion" class="selectpicker">
	        <option selected disabled>Choose...</option>
	        <%for(String e: ediciones){ %>
	        <option value="<%= e %>"><%= e %></option>
	        <%} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Mostrar Informacion</button>
	</div>
</form>
<%}else if(session.getAttribute("optConsultaEdicionInfoEdicion").toString().equals("3")) {%>
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