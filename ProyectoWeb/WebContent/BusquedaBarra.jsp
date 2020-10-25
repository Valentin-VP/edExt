<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title> Tu Busqueda </title>
</head>
<body>
<% 
	String textoFiltrado = (String) sesion.getAttribute("filtrado");
	String textoOrdenado = (String) sesion.getAttribute("ordenado");
	ArrayList <String> cursosAMostrar = (ArrayList) sesion.getAttribute("todosLosCursos");
	System.out.println("Se recupera un filtrado " + textoFiltrado);
	System.out.println("Se recupera un ordenado " + textoOrdenado);
	
%>
<h1 align="center"> Resultados de la busqueda </h1>
<br><br>
<form action="FiltradoYBusqueda" method="post">
	<div class="form-row">
		<div align="center" class="form-group col-md-6">
		  <label for="comboFiltrado">Filtrado</label>
	      <select id="comboFiltrado" name="comboFiltrado" class="selectpicker" required>
	        <option></option>
	        <option value="curso">curso</option>
	        <option value="programa">programa</option>
	      </select>
		</div>
		<div align="center" class="form-group">
		  <label for="comboOrdenado">Ordenado</label>
	      <select id="comboOrdenado" name="comboOrdenado" class="selectpicker" required>
	        <option></option>
	        <option value="alfabeticamente">alfabeticamente(ascendente)</option>
	        <option value="fecha">fecha(descendente)</option>
	      </select>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">Filtrar</button>
		</div>
	</div>
	<br><br>
	<div class="form-row">
	<% if(textoFiltrado != null) {%>
		<h5> Filtrado por: <%= textoFiltrado %> </h5>
	<%} %>
	<% if(textoOrdenado != null) {%>	
		<h5> Ordenado por: <%= textoOrdenado %> </h5>
	<%} %>
	</div>
	<br><br>
	<h3 align="center"> Se muestran resultados </h3>
	<%for(String curso: cursosAMostrar){ %>
		<p>
		<%=curso %>
		</p>
	<%} %>
</form>
<%@include file = "/footer.jsp" %>
</body>
</html>
