<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "header.jsp" %>
<title>Informacion de un curso</title>
<style>
	#insCat{
		left: 30px;
	}
	#botonInsCat{
		position: relative;
	  	height: 40px;
  		top: 0px;
	}
</style>
<%
session.setAttribute("optConsultaCursoInfoCurso", request.getParameter("optConsultaCursoInfoCurso"));

boolean esInstitutoInfoCurso = sesion.getAttribute("esInstituto") != null;
boolean esCategoriaInfoCurso = sesion.getAttribute("esCategoria") != null;
%>
</head>
<body>
<form action="ConsultarCurso" method="post">
  <div class="form-row">
  <input type="text" name="optConsultaCursoInfoCurso" value="<%=request.getParameter("optConsultaCursoInfoCurso")%>">
  <input type="text" name="esInstitutoInfoCurso" value="<%=esInstitutoInfoCurso%>">
  <input type="text" name="esCategoriaInfoCurso" value="<%=esCategoriaInfoCurso%>">
    <div class="col-md-3" id="insCat">
    	<input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstituto">
    	<label class="form-check-label" for="checkInstituto">Instituto</label>
    </div>
    <div>
	    <input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoria">
	    <label class="form-check-label" for="checkCategoria">Categoria</label>
    </div>
  </div>
  <br>
  <div class="form-row">
  	<div class="col-md-6">
	    <input type="text" name="instituto-categoria" class="form-control" id="instituto-categoria" required>
    </div>
    <button class="btn btn-primary" id="botonInsCat" type="submit">Submit form</button>
  </div>
</form>
<form>
	
</form>
</body>
</html>