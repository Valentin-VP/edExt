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
<style>
#listaResultados{
float : center;
position: relative;
}
</style>

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
	      <select id="comboFiltrado" name="comboFiltrado" class="selectpicker">
	        <option></option>
	        <option value="curso">curso</option>
	        <option value="programa">programa</option>
	      </select>
		</div>
	
		<div align="center" class="form-group">
		  <label for="comboOrdenado">Ordenado</label>
	      <select id="comboOrdenado" name="comboOrdenado" class="selectpicker">
	        <option></option>
	        <option value="alfabeticamente">alfabeticamente(ascendente)</option>
	        <option value="fecha">fecha(descendente)</option>
	      </select>
		</div>
		<div>
			<button type="submit" class="btn btn-danger">Aplicar</button>
		</div>
	</div>
</form>

	<br><br>
<form action="ConsultarCurso" method="post">	
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
	<br><br>
	<div class="container" align=center>
		<div id="listaResultados" class="form-group">
		<select id="dropdownCursos" name="dropdownCursos" class="selectpicker" required>	
			<%if (cursosAMostrar != null) { 
				for(String curso: cursosAMostrar) { %>
					<option value="<%=curso %>"><%=curso %></option>
				<%}
			
			}else{%>
				<option value="No hay resultados">No hay resultados</option>
			<%} %>
		</select>
		</div>
		<br><br>
		<%sesion.setAttribute("optConsultaCursoInfoCurso", 1); %>
		<div>
			<button type="submit" class="btn btn-danger">Ver Resultado</button>
		</div>
	</div>
</form>	


<%@include file = "/footer.jsp" %>
</body>
</html>
