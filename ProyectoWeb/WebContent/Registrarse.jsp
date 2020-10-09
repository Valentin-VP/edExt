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
        <option selected>Choose...</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
      </select>
  </div>
  <div class="form-group col-md-3">
      <label for="inputMes">Mes</label>
      <select id="inputMes" name="MesNac" class="selectpicker">
        <option selected>Choose...</option>
        <option value="1">enero</option>
        <option value="2">febrero</option>
        <option value="3">marzo</option>
      </select>
  </div>
  <div class="form-group col-md-3">
      <label for="inputAnio">Anio</label>
      <select id="inputAnio" name="AnioNac" class="selectpicker">
        <option selected>Choose...</option>
        <option value="1997">1997</option>
        <option value="1998">1998</option>
        <option value="1999">1999</option>
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