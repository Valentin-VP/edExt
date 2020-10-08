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
	HttpSession s = (HttpSession) request.getSession();
	@SuppressWarnings("unchecked")
	ArrayList<String> cursos = (ArrayList<String>) s.getAttribute("cursosInfoEdicion");
	@SuppressWarnings("unchecked")
	ArrayList<String> ediciones = (ArrayList<String>) s.getAttribute("edicionesInfoEdicion");
	DtEdicion infoEdicion = (DtEdicion) s.getAttribute("infoEdicion");
	
	if(s.isNew() || cursos == null) {%>
<form action="obtenerCursos" method="post">
	<div class="form-row">
		<div class="form-check">
	      <input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstituto">
	      <label class="form-check-label" for="checkInstituto">Es Instituto</label>
	    </div>
	    <div class="form-check col-md-2">
	      <input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoria">
	      <label class="form-check-label" for="checkCategoria">Es Categoria</label>
	    </div>
	</div>
	<br>
	<div class="form-row">
		<div class="form-group col-md-3">
	      <input type="text" name="InsCat" class="form-control" id="InsCat">
	    </div>
      	<button type="submit" class="btn btn-primary">Buscar Cursos</button> 
	</div>
</form>
<%} else if(cursos != null && ediciones == null) {%>
<form action="obtenerEdiciones" method="post">
	<div class="form-row">
		<div class="form-group col-md-6">
	      <label for="inputCurso">Curso</label>
	      <select id="inputCurso" name="curso" class="selectpicker">
	        <option selected disabled>Choose...</option>
	        <%for(String c: cursos){ %>
	        <option value="<%= c %>"><%= c %></option>
	        <%} %>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Buscar Ediciones</button>
	</div>
</form>
<%} else if(cursos != null && ediciones != null) { %>
<form action="obtenerInfoEdicion" method="post">
	<div class="form-row">
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
<%}
  if(infoEdicion != null) {%>
<form>
<!-- mostrar la informacion de la edicion seleccionada -->
<h4> falta mostrar los datos de la edicion </h4>
</form>
<%} %>  
<%@include file = "/footer.jsp" %>
</body>
</html>