<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
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
		display: none;
	}
</style>

<%
System.out.println(session.getAttribute("optConsultaCursoInfoCurso"));
if(session.getAttribute("optConsultaCursoInfoCurso").toString().equals("0")){ 
	System.out.println("entro al if de info");
	session.setAttribute("cursosConsulta", null);
} 
ArrayList<String> cursosConsulta = (ArrayList) session.getAttribute("cursosConsulta");
boolean esInstitutoInfoCurso = sesion.getAttribute("esInstitutoInfoCurso") != null;
boolean esCategoriaInfoCurso = sesion.getAttribute("esCategoriaInfoCurso") != null;
System.out.println(cursosConsulta);
%>
</head>
<body>
	<form action="ConsultarCurso" method="post">
	  <div class="form-row">
	  <!-- <input type="text" name="optConsultaCursoInfoCurso" value="<%=request.getParameter("optConsultaCursoInfoCurso")%>">
	  <input type="text" name="esInstitutoInfoCurso" value="<%=esInstitutoInfoCurso%>">
	  <input type="text" name="esCategoriaInfoCurso" value="<%=esCategoriaInfoCurso%>">-->
	    <div class="col-md-3" id="insCat">
	    	<input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstituto"  checked>
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
	    <button class="btn btn-primary" id="botonInsCat" type="submit" >Aceptar</button>
	  </div>
	</form>
	
	<div class="form-row">
	  	<div class="form-group col-md-3">
	      <label for="inputDia">Cursos</label>
	      <select id="inputDia" name="DiaNac" class="dropdown">
	        <option selected>Choose...</option>
	        <option value="1">1</option>
	        <option value="2">2</option>
	        <option value="3">3</option>
	      </select>
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
</body>
</html>