<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
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
		
	}
	#buscarCursos{
		position: relative;
	  	height: 39px;
  		
	}
</style>


<%
sesion.setAttribute("optConsultaCursoInfoCurso", "0");
ArrayList<String> cursosConsulta = (ArrayList) sesion.getAttribute("cursosConsulta");
if(cursosConsulta == null){
	cursosConsulta = new ArrayList<String>();
}
ArrayList<String> infoCurso = (ArrayList) sesion.getAttribute("infoCurso");
if(infoCurso == null){
	infoCurso = new ArrayList<String>();
}
boolean esInstitutoInfoCurso = sesion.getAttribute("esInstitutoInfoCurso") != null;
boolean esCategoriaInfoCurso = sesion.getAttribute("esCategoriaInfoCurso") != null;
System.out.println(cursosConsulta);
%>
</head>
<body>
	<form action="ConsultarCurso" method="post">
	  <div class="form-row">
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
	    <button class="btn btn-primary" id="botonInsCat" type="submit" onclick="mostrarTable()" >Aceptar</button>
	  </div>
	</form>
	
	<form action="ConsultaCurso" method="post">
	   <div class="form-row">	
	      <div class="form-group col-md-4">
		      <select id="dropdownCursos" name="dropdownCursos" class="selectpicker">
		      	<option selected disabled>Curso</option>
		        <%for(String c: cursosConsulta){
		        	%><option value="<%=c %>"><%= c %></option><%
		        } %>
		      </select>
		   </div> 
		   <%if(!cursosConsulta.isEmpty()) {
			   sesion.setAttribute("optConsultaCursoInfoCruso", 1);
		   }%>
	      <button type="submit" class="btn btn-secondary" id="buscarCursos">Buscar</button>
	      </div>
	   </div>
	</form> 
		  		
		  	
	
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
<%@include file = "/footer.jsp" %>
</body>
</html>