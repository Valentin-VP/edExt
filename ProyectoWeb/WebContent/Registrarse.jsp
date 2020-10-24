<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Registro de un Usuario</title>
</head>
<body>
<% HttpSession s = (HttpSession) request.getSession();
	@SuppressWarnings("unchecked")
	ArrayList<String> institutos = (ArrayList<String>) s.getAttribute("institutos");
%>
<form action="AltaUsuario" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Correo</label>
      <input type="email" name="correo" class="form-control" id="inputCorreo4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputNick4">Nickname</label>
      <input type="Text" name="nick" class="form-control" id="inputNick4">
    </div>
  </div> 
  <div class="form-row"> 
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" name="pass" class="form-control" id="inputPassword4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputVerificacion4">Confirmar Password</label>
      <input type="password" name="verificar" class="form-control" id="inputVerificacion4">
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-3">
      <label for="inputDia">Dia</label>
      <select id="inputDia" name="DiaNac" class="selectpicker">
        <option selected disabled>Choose...</option>
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
      <label for="inputMes">Mes</label>
      <select id="inputMes" name="MesNac" class="selectpicker">
        <option selected disabled>Choose...</option>
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
      <label for="inputAnio">Anio</label>
      <select id="inputAnio" name="AnioNac" class="selectpicker">
        <option selected disabled>Choose...</option>
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
  <div class="form-row">
  	<div class="form-group col-md-6">
    	<label for="inputNombre">Nombre</label>
    	<input type="text" name="nombre" class="form-control" id="inputNombre" placeholder="Elver">
  	</div>
  		<div class="form-group col-md-6">
    	<label for="inputApellido">Apellido</label>
    	<input type="text" name="apellido" class="form-control" id="inputApellido" placeholder="Galarga">
  	</div>
  </div>
  <div class="form-row">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="docente" name="esDocente" value="true" onclick="cargarCombo()">
      <label class="form-check-label" for="gridCheck">Docente</label>
    </div>
  </div>
  <br>
  <script> function cargarCombo() {
       	if (document.getElementById("docente").checked) {
       	<% if (institutos != null) { 
       	for(String i: institutos) { %>
    	document.getElementById("inputInstituto").innerHTML = '<option value="<%= i %>"> <%= i %> </option>';
    <% } %>
  	<% } %>
  }
  }</script>
  <div class="form-group col-md-6">
      <label for="inputInstituto">Instituto</label>
      <select id="inputInstituto" name="instituto" class="selectpicker">
         <option selected>Choose...</option>
         <option value="crandon">crandon</option>
        <option selected>Choose...</option>
      </select>
  </div>
  <button type="submit" class="btn btn-primary">Registrarse</button>
</form>

<%@include file = "/footer.jsp" %>
</body>
</html>