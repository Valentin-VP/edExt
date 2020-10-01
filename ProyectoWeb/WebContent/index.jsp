<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#listaInstitutos {
  position: absolute;
  top: 200px;
  left: 0;
  width: 200px;
  height: 150px;
  border: 3px solid #73AD21;
  overflow: auto;
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Pagina de Inicio</title>
</head>
<body>

	<div class="text-right"> 
        <a role="button" href="IniciarSesion.jsp" class="btn btn-secondary">Inicias Sesion</a>
        <a role="button" href="Registrarse.jsp" class="btn btn-secondary">Registrarse</a> 
    </div>
               
    <div id="listaInstitutos" class="list-group">
	  	<a href="#" class="list-group-item list-group-item-action">Crandon</a>
	  	<a href="#" class="list-group-item list-group-item-action">Udelar</a>
	  	<a href="#" class="list-group-item list-group-item-action">UTU</a>
	  	<a href="#" class="list-group-item list-group-item-action">UTEC</a>
	  	<a href="#" class="list-group-item list-group-item-action">Kenedy</a>
	</div>
 
<%@include file = "/footer.jsp" %>
</body>
</html>