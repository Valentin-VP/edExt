<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Ingrese un Nuevo Curso</title>
</head>
<body>
<%
//Codigo Java
%>

<form action="altaCurso" method="post">
	<div class="container">
	  <div class="row">
		    <div class="col-sm">
		      
		      	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Instituto</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="StarkInstitutes" aria-label="Username" aria-describedby="basic-addon1" name=institutoTextField>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Nombre</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="Ironman" aria-label="Username" aria-describedby="basic-addon1" name=cursoTextField>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Descripcion</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="The best hero" aria-label="Username" aria-describedby="basic-addon1" name=descripcionTextField>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Cantidad Horas</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="0" aria-label="Username" aria-describedby="basic-addon1" name=canthorasTextField>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Creditos</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="0" aria-label="Username" aria-describedby="basic-addon1" name=creditosTextField>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">URL</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="www" aria-label="Username" aria-describedby="basic-addon1" name=urlTextField>
		</div>
	</div>
		      
		    </div>
		    <div class="col-sm">
		      One of three columns
		    </div>
	  </div>
	</div>





</form>
<%@include file = "/footer.jsp" %>
</body>
</html>