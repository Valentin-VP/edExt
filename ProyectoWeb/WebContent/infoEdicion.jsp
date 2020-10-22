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
session.setAttribute("optConsultaEdicionInfoEdicion", request.getParameter("optConsultaEdicionInfoEdicion"));

ArrayList<String> cursos = (ArrayList) session.getAttribute("cursosInfoEdicion");
ArrayList<String> ediciones = (ArrayList) session.getAttribute("edicionesInfoEdicion");
boolean esInstitutoInfoEdicion = sesion.getAttribute("esInstitutoEd") != null;
boolean esCategoriaInfoEdicion = sesion.getAttribute("esCategoriaEd") != null;
//String cursoConsultaEdicion = (String) sesion.getAttribute("cursoConsultaEdicion");
//String edicionConsultaEdicion = (String) sesion.getAttribute("edicionConsultaEdicion");
	
if(session.getAttribute("optConsultaEdicionInfoCurso") == "0") {%>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>">
	<input type="text" name="esInstitutoInfoEdicion" value="<%=esInstitutoInfoEdicion%>">
  	<input type="text" name="esCategoriaInfoEdicion" value="<%=esCategoriaInfoEdicion%>">
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
	      <input type="text" name="InsCatEd" class="form-control" id="InsCatEd">
	    </div>
      	<button type="submit" class="btn btn-primary">Buscar Cursos</button> 
	</div>
</form>
<%} else if(session.getAttribute("optConsultaEdicionInfoCurso") == "1") {%>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>">
	
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
<%} else if(session.getAttribute("optConsultaEdicionInfoCurso") == "2") { %>
<form action="ConsultaEdicion" method="post">
	<div class="form-row">
	<input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>">
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
  if(session.getAttribute("optConsultaEdicionInfoCurso") == "3") {%>
<form>
	<input type="text" name="optConsultaEdicionInfoEdicion" value="<%=request.getParameter("optConsultaEdicionInfoEdicion")%>">
<!-- mostrar la informacion de la edicion seleccionada -->
<h4> falta mostrar los datos de la edicion </h4>
</form>
<% } %>  
<%@include file = "/footer.jsp" %>
</body>
</html>