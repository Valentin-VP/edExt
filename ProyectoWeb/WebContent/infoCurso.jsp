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
	#nomIns{
		margin: auto;
		width: 100%;
		padding: 10px;
	}
	#insCat{
		
		left: 30px;
	}
	#botonInsCat{
		position: relative;
	  	height: 40px;
  		top: 0px;
	}
	#tabla{
		position: relative; 
		left: 0px;
		
	}
	#buscarCursos{
		position: relative;
	  	height: 39px;
  		
	}
	#dropCursos{
		margin: auto;
	}

</style>

<%
System.out.println(sesion.getAttribute("optConsultaCursoInfoCurso"));
if(sesion.getAttribute("optConsultaCursoInfoCurso") == null){	
	sesion.setAttribute("optConsultaCursoInfoCurso", "0");
}
ArrayList<String> cursosConsulta = (ArrayList) sesion.getAttribute("cursosConsulta");
if(cursosConsulta == null){
	cursosConsulta = new ArrayList<String>();
}
ArrayList<String> infoCurso = (ArrayList) sesion.getAttribute("infoCurso");
if(infoCurso == null){
	infoCurso = new ArrayList<String>();
}
ArrayList<String> edicionesConsulta = (ArrayList) sesion.getAttribute("edicionesConsultaCurso");
if(edicionesConsulta == null){
	edicionesConsulta = new ArrayList<String>();
}
System.out.println(cursosConsulta);
%>
</head>
<body>
	<h1 align="center"> Consulta Curso </h1>
	<br><br>
	<form action="ConsultarCurso" method="post">
		<div class="form-row" id="nombres">
			<div class="col-md-3" id="insCat">
	    		<input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstitutoInfoEdicion"  checked>
	    		<label class="form-check-label" for="checkInstituto">Instituto</label>
	    	</div>
	    	<div>
		    	<input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoriaInfoEdicion">
		    	<label class="form-check-label" for="checkCategoria">Categoria</label>
	    	</div>
	  	</div>
	  	<div class="form-row" id="nomIns">
	  		<div class="col-md-6">
		    	<input type="text" name="instituto-categoria" class="form-control" id="instituto-categoria" required>
	    	</div>
	    	<button class="btn btn-primary" id="botonInsCat" type="submit" onclick="setOpt()">Aceptar</button>
	  	</div>
	</form>
	<br></br>
	<form action="ConsultarCurso" method="post">
	   <div class="form-row" id="dropCursos">	
	      <div class="form-group col-md-4">
		      <select id="dropdownCursos" name="dropdownCursos" class="selectpicker" required>
		      	<option></option>
		        <%for(String c: cursosConsulta){%>
					<option value="<%=c %>"><%= c %></option><%
				}%>
		      </select>
		  </div> 
	      <button type="submit" class="btn btn-secondary" id="buscarCursos">Buscar</button>
		</div>
	</form> 
		  		
		  	
	<%if(!infoCurso.isEmpty()){%>
		<div class="form-row" id="tabla">
			<table class="table">
	 			<tbody>
	 				<tr>
	     				<th scope="row">Nombre del curso</th>
	     				<td><%=infoCurso.get(0)%></td>
					</tr>
					<tr>
					<th scope="row">Descripcion</th>
						<td><%=infoCurso.get(1) %></td>
					</tr>
					<tr>
						<th scope="row">Duracion</th>
						<td><%=infoCurso.get(2) %></td>
					</tr>
					<tr>
						<th scope="row">Cant. horas</th>
						<td><%=infoCurso.get(3) %></td>
					</tr>
					<tr>
						<th scope="row">Creditos</th>
						<td><%=infoCurso.get(4) %></td>
					</tr>
					<tr>
						<th scope="row">URL</th>
						<td><%=infoCurso.get(5) %></td>
					</tr>
					<tr>
						<th scope="row">Categorias a las que pertenece</th>
					 	<td><%=infoCurso.get(6) %></td>
				</tbody>
			</table>
		</div>
	
		<form action="ConsultaEdicion" method="post">
		 	<div class="form-row" id="dropEdiciones">	
				<div class="form-group col-md-4">
					<label id="edicion">Edicion</label>
					<select id="dropdownEdiciones" name="edicion" class="selectpicker" required>
			     		<option></option>
			        	<%for(String c: edicionesConsulta){%>
			        		<option value="<%=c %>"><%= c %></option><%
						}%>
			      	</select>
			  	</div> 
			  	<%sesion.setAttribute("InsCatEd",sesion.getAttribute("institutoConsultaCurso").toString());
			  	sesion.setAttribute("cursoConsultaEdicion", sesion.getAttribute("cursoConsulta").toString());
			  	sesion.setAttribute("optConsultaEdicionInfoEdicion", 5);
			  	%>
		      	<button type="submit" class="btn btn-secondary" id="buscarCursos">Consultar</button>
			</div>
		</form><%
	}%>	
	
<script>
	function setOpt(){
		sesion.setAttribute("optConsultaCursoInfoCurso", "0");
	}
</script>

<%@include file = "/footer.jsp" %>
</body>
</html>