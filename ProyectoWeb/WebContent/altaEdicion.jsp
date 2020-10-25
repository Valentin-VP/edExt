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
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2003</option>
	          <option value="1994">2004</option>
	          <option value="1995">2005</option>
	          <option value="1996">2006</option>
	          <option value="1997">2007</option>
	          <option value="1998">2008</option>
	          <option value="1999">2009</option>
	          <option value="2000">2010</option>
	          <option value="2001">2011</option>
	          <option value="2002">2012</option>
	          <option value="2013">2013</option>
	          <option value="2014">2014</option>
	          <option value="2015">2015</option>
	          <option value="2016">2016</option>
	          <option value="2017">2017</option>
	          <option value="2018">2018</option>
	          <option value="2019">2019</option>
	          <option value="2020">2020</option>
	          <option value="2021">2021</option>
	          <option value="2022">2022</option>
	          <option value="2023">2023</option>
	          <option value="2024">2024</option>
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
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2003</option>
	          <option value="1994">2004</option>
	          <option value="1995">2005</option>
	          <option value="1996">2006</option>
	          <option value="1997">2007</option>
	          <option value="1998">2008</option>
	          <option value="1999">2009</option>
	          <option value="2000">2010</option>
	          <option value="2001">2011</option>
	          <option value="2002">2012</option>
	          <option value="2013">2013</option>
	          <option value="2014">2014</option>
	          <option value="2015">2015</option>
	          <option value="2016">2016</option>
	          <option value="2017">2017</option>
	          <option value="2018">2018</option>
	          <option value="2019">2019</option>
	          <option value="2020">2020</option>
	          <option value="2021">2021</option>
	          <option value="2022">2022</option>
	          <option value="2023">2023</option>
	          <option value="2024">2024</option>
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
	          <option value="2000">2000</option>
	          <option value="2001">2001</option>
	          <option value="2002">2003</option>
	          <option value="1994">2004</option>
	          <option value="1995">2005</option>
	          <option value="1996">2006</option>
	          <option value="1997">2007</option>
	          <option value="1998">2008</option>
	          <option value="1999">2009</option>
	          <option value="2000">2010</option>
	          <option value="2001">2011</option>
	          <option value="2002">2012</option>
	          <option value="2013">2013</option>
	          <option value="2014">2014</option>
	          <option value="2015">2015</option>
	          <option value="2016">2016</option>
	          <option value="2017">2017</option>
	          <option value="2018">2018</option>
	          <option value="2019">2019</option>
	          <option value="2020">2020</option>
	          <option value="2021">2021</option>
	          <option value="2022">2022</option>
	          <option value="2023">2023</option>
	          <option value="2024">2024</option>
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