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
	#tabla{
		position: absolute; 
		left: 0px;
		display: "none";
	}
</style>
<script>
	if()
</script>
<%
session.setAttribute("optConsultaCursoInfoCurso", request.getParameter("optConsultaCursoInfoCurso"));

boolean esInstitutoInfoCurso = sesion.getAttribute("esInstitutoEd") != null;
boolean esCategoriaInfoCurso = sesion.getAttribute("esCategoriaEd") != null;
%>
</head>
<body>
<form action="ConsultarCurso" method="post">
  <div class="form-row">
  <!-- <input type="text" name="optConsultaCursoInfoCurso" value="<%=request.getParameter("optConsultaCursoInfoCurso")%>">
  <input type="text" name="esInstitutoInfoCurso" value="<%=esInstitutoInfoCurso%>">
  <input type="text" name="esCategoriaInfoCurso" value="<%=esCategoriaInfoCurso%>">-->
    <div class="col-md-3" id="insCat">
    	<input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstituto">
    	<label class="form-check-label" for="checkInstituto">Instituto</label>
    </div>
    <div>
	    <input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoria">
	    <label class="form-check-label" for="checkCategoria">Categoria</label>
    </div>
  </div>
  <div class="form-row">
  	<div class="col-md-6">
	    <input type="text" name="instituto-categoria" class="form-control" id="instituto-categoria" required>
    </div>
    <button class="btn btn-primary" id="botonInsCat" type="submit">Submit form</button>
  </div>
  <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropCursos" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Cursos
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
  </div>
</div>
  <div class="container" id="tabla">
  	<table class="table">
	  <tbody>
	    <tr>
	      <th scope="row">Nombre del curso</th>
	      <td>Mark</td>
	    </tr>
	    <tr>
	      <th scope="row">Descripcion</th>
	      <td>Jacob</td>
	    </tr>
	    <tr>
	      <th scope="row">Duracion</th>
	      <td>Larry</td>
	    </tr>
	    <tr>
	      <th scope="row">Cant. horas</th>
	      <td>Larry</td>
	    </tr>
	    <tr>
	      <th scope="row">Creditos</th>
	      <td>Larry</td>
	    </tr>
	    <tr>
	      <th scope="row">URL</th>
	      <td>Larry</td>
	    </tr>
	    <tr>
	      <th scope="row">Categorias a las que pertenece</th>
	      <td>Larry</td>
	  </tbody>
	</table>
  </div>
</form>

</body>
</html>