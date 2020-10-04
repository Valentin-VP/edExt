<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Iniciar Sesion de un Usuario</title>
</head>
<body>
<h1 align="center"> Ingrese sus datos para iniciar la sesion </h1>
<form action="ConsultarTipoUsuario" method="post">
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="nick">Nickname/Correo</label>
      <input type="text" name="nick-correo" class="form-control" id="nick-correo" value="Elver" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="pass">Contrasenia</label>
      <input type="password" name="pass" class="form-control" id="pass" required>
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit form</button>
</form>
<%@include file = "/footer.jsp" %>
</body>
</html>