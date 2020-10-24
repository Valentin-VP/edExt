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
<h1 align="center"> Ingrese el Instituto </h1>
<br><br>
<form action="AltaEdicionCurso" method="post">
   <div class="form-row">
      <div class="form-group col-md-10">
	      <input type="text" name="institutoAltaEd" class="form-control" id="inputInstituto">
	   </div>
	   <button type="submit" class="btn btn-primary">Buscar Cursos</button>
   </div>   
</form>    
<% } else if(session.getAttribute("optAltaEdicionAltaEd").toString().equals("1")){%>
<h1 align="center"> Resultados de la busqueda </h1>
<br><br>
<form action="AltaEdicionCurso" method="post">
	<div class=form-row>
	  	<div class="form-group col-md-5">
	  	  <label for="inputCurso">cursos</label>
	        <select class="selectpicker" id="inputCurso" name="curso" title="Elije un curso">
	          <%for(String c: cursos) { %>
	          <option value="<%= c %>"><%= c %></option>
	          <% } %>
	        </select>
	    </div>
	    <div class="form-check col-md-3">
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
	  	  <div class="form-group col-md-3">
	        <label for="inputDiaI">Dia Inicio</label>
	        <select id="inputDiaI" name="DiaI" class="selectpicker">
	          <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesI">Mes Inicio</label>
	        <select id="inputMesI" name="MesI" class="selectpicker">
	          <option value="1">enero</option>
        <option value="2">febrero</option>
        <option value="3">marzo</option>
        <option value="4">abril</option>
        <option value="5">mayo</option>
        <option value="6">junio</option>
        <option value="7">julio</option>
        <option value="8">agosto</option>
        <option value="9">setiembre</option>
        <option value="10">octubre</option>
        <option value="11">noviembre</option>
        <option value="12">diciembre</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioI">Anio Inicio</label>
	        <select id="inputAnioI" name="AnioI" class="selectpicker">
	          <option value="1994">1994</option>
	          <option value="1995">1995</option>
	          <option value="1996">1996</option>
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2002</option>
	        </select>
	    </div>
    </div>
    <br><br>
  	<div class="form-row">
	  	  <div class="form-group col-md-3">
	        <label for="inputDiaF">Dia Fin</label>
	        <select id="inputDiaF" name="DiaF" class="selectpicker">
	          <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesF">Mes Fin</label>
	        <select id="inputMesF" name="MesF" class="selectpicker">
	          <option value="1">enero</option>
	          <option value="2">febrero</option>
	          <option value="3">marzo</option>
	          <option value="4">abril</option>
	          <option value="5">mayo</option>
	          <option value="6">junio</option>
	          <option value="7">julio</option>
	          <option value="8">agosto</option>
	          <option value="9">setiembre</option>
	          <option value="10">octubre</option>
	          <option value="11">noviembre</option>
	          <option value="12">diciembre</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioF">Anio Fin</label>
	        <select id="inputAnioF" name="AnioF" class="selectpicker">
	          <option value="1994">1994</option>
	          <option value="1995">1995</option>
	          <option value="1996">1996</option>
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2002</option>
	        </select>
	    </div>
    </div>
    <br><br>
    <div class="form-row">
	  	  <div class="form-group col-md-3">
	        <label for="inputDiaP">Dia Pub</label>
	        <select id="inputDiaP" name="DiaP" class="selectpicker">
	          <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputMesP">Mes Pub</label>
	        <select id="inputMesP" name="MesP" class="selectpicker">
	          <option value="1">enero</option>
	          <option value="2">febrero</option>
	          <option value="3">marzo</option>
	          <option value="4">abril</option>
	          <option value="5">mayo</option>
	          <option value="6">junio</option>
	          <option value="7">julio</option>
	          <option value="8">agosto</option>
	          <option value="9">setiembre</option>
	          <option value="10">octubre</option>
	          <option value="11">noviembre</option>
	          <option value="12">diciembre</option>
	        </select>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="inputAnioP">Anio Pub</label>
	        <select id="inputAnioP" name="AnioP" class="selectpicker">
	          <option value="1994">1994</option>
	          <option value="1995">1995</option>
	          <option value="1996">1996</option>
	          <option value="1997">1997</option>
	          <option value="1998">1998</option>
	          <option value="1999">1999</option>
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2002</option>
	        </select>
	    </div>
    </div>
    <br><br>
	<div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="docentes">Seleccione los docentes</label>
	      <select id="docentes" name="docentes" class="selectpicker" multiple="multiple">
  			<%for(String d: docentes) { %>
	        <option value="<%= d %>"> <%= d %> </option>
	        <% } %>
		  </select>
	    </div>
	    <button type="submit" class="btn btn-primary">Confirmar</button>
	</div>
</form>
<% } %>
<%@include file = "/footer.jsp" %>
</body>
</html>