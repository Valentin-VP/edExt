<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Crear una nueva edicion para un curso</title>
</head>
<body>
<% 	
	if(session.getAttribute("optAltaEdicionAltaEd") == null){
		session.setAttribute("optAltaEdicionAltaEd", request.getParameter("optAltaEdicionAltaEd"));
	}
	@SuppressWarnings("unchecked")
	ArrayList<String> docentes = (ArrayList<String>) session.getAttribute("docentes");
	@SuppressWarnings("unchecked")
	ArrayList<String> cursos = (ArrayList<String>) session.getAttribute("cursos");

if(session.getAttribute("optAltaEdicionAltaEd").toString().equals("0")) {%>
<form action="AltaEdicionCurso" method="post"> <!-- me traigo los cursos y los docentes del instituto -->
   <div class="form-row">	
      <div class="form-group col-md-4">
	      <label for="inputInstituto">Instituto</label>
	      <select id="inputInstituto" name="instituto" class="selectpicker">
	        <option selected disabled>Choose...</option> <!-- hay que traer todos los institutos y hacer un for, capaz que es en otro servlet-->
	        <option value="crandon">Crandon</option>
	      </select>
	   </div>
   </div>   
   <div class="form-row">
      <button type="submit" class="btn btn-primary">Buscar Cursos</button>
   </div>
</form>    
<% } else if(session.getAttribute("optAltaEdicionAltaEd").toString().equals("1")){%>
<form action="AltaEdicionCurso" method="post">
	<div class=form-row>
	  	<div class="form-group col-md-3">
	  	  <label for="inputCurso">cursos</label>
	        <select class="selectpicker" id="inputCurso" name="curso" title="Elije un curso">
	          <%for(String c: cursos) { %>
	          <option value="<%= c %>"><%= c %></option>
	          <% } %>
	        </select>
	    </div>
	    <div class="form-check col-md-2">
	      <input class="form-check-input" type="checkbox" id="gridCheck" name="tieneCupos">
	      <label class="form-check-label" for="gridCheck">Cupos</label>
	    </div>
	    <div class="form-group col-md-1">
	      <label for="inputCupos">Cantidad</label>
	      <input type="text" name="cantidadCupos" class="form-control" id="inputCupos" value="0">
	    </div>
	</div>
	<br>
	<div class="form-row">
		<div class="form-group col-md-6">
	      <label for="inputNombre">Nombre</label>
	      <input type="text" name="nombreEdicion" class="form-control" id="inputNombre">
	    </div>
	</div>
	<br>
	<div class="form-row">
	  	  <div class="form-group col-md-3"> <!-- fecha de inicio -->
	        <label for="inputDiaI">Dia Inicio</label>
	        <select id="inputDiaI" name="DiaI" class="selectpicker">
	          <option value="1">1</option>
	          <option value="2">2</option>
	          <option value="3">3</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesI">Mes Inicio</label>
	        <select id="inputMesI" name="MesI" class="selectpicker">
	          <option value="1">enero</option>
	          <option value="2">febrero</option>
	          <option value="3">marzo</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioI">Anio Inicio</label>
	        <select id="inputAnioI" name="AnioI" class="selectpicker">
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	        </select>
	    </div>
    </div>
    <br>
  	<div class="form-row">
	  	  <div class="form-group col-md-3"> <!-- fecha de Fin -->
	        <label for="inputDiaF">Dia Fin</label>
	        <select id="inputDiaF" name="DiaF" class="selectpicker">
	          <option value="1">1</option>
	          <option value="2">2</option>
	          <option value="3">3</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesF">Mes Fin</label>
	        <select id="inputMesF" name="MesF" class="selectpicker">
	          <option value="1">enero</option>
	          <option value="2">febrero</option>
	          <option value="3">marzo</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioF">Anio Fin</label>
	        <select id="inputAnioF" name="AnioF" class="selectpicker">
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	        </select>
	    </div>
    </div>
    <br>
    <div class="form-row">
	  	  <div class="form-group col-md-3"> <!-- fecha de Publicacion -->
	        <label for="inputDiaP">Dia Pub</label>
	        <select id="inputDiaP" name="DiaP" class="selectpicker">
	          <option value="1">1</option>
	          <option value="2">2</option>
	          <option value="3">3</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesP">Mes Pub</label>
	        <select id="inputMesP" name="MesP" class="selectpicker">
	          <option value="1">enero</option>
	          <option value="2">febrero</option>
	          <option value="3">marzo</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioP">Anio Pub</label>
	        <select id="inputAnioP" name="AnioP" class="selectpicker">
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	        </select>
	    </div>
    </div>
	<div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="docentes">Seleccione los docentes</label>
	      <select id="docentes" name="docentes" class="selectpicker" multiple="multiple">
  			<%for(String d: docentes) { %>
	        <option value="<%= d %>"> <%= d %> </option>
	        <% } %>
		  </select>
	    </div>
	</div>
	<div class="form-row">
		<button type="submit" class="btn btn-primary">Confirmar</button>
	</div>
</form>
<% } %>
<%@include file = "/footer.jsp" %>
</body>
</html>