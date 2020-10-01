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
<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Correo</label>
      <input type="email" class="form-control" id="inputCorreo4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputNick4">Nickname</label>
      <input type="Text" class="form-control" id="inputNick4">
    </div>
  </div> 
  <div class="form-row"> 
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" id="inputPassword4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputVerificacion4">Confirmar Password</label>
      <input type="password" class="form-control" id="inputVerificacion4">
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-6">
    	<label for="inputNombre">Nombre</label>
    	<input type="text" class="form-control" id="inputNombre" placeholder="Elver">
  	</div>
  		<div class="form-group col-md-6">
    	<label for="inputApellido">Apellido</label>
    	<input type="text" class="form-control" id="inputApellido" placeholder="Galarga">
  	</div>
  </div>
  <div class="form-row">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">Docente</label>
    </div>
  </div>
  <br>
  <div class="form-group col-md-6">
      <label for="inputInstituto">Instituto</label>
      <select id="inputInstituto" class="form-control">
        <option selected>Choose...</option>
        <option>...</option>
      </select>
    </div>
  <button type="submit" class="btn btn-primary">Registrarse</button>
</form>

<%@include file = "/footer.jsp" %>
</body>
</html>