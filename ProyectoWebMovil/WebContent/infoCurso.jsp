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

	#ins{
		margin-left:15%;
	}
	#cat{
		margin-left:15%;
	}
	#nomInsAceptar{
		display: block;
		margin: auto;

	}
	#tabla{
		position: relative; 
		left: 0px;
		
	}
	#buscarCursos{
		display: block;
	  	mergin:auto;
  		
	}
	#dropCursos{
		display: block;
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
System.out.println(infoCurso);
%>
</head>
<body>
	<h1 align="center"> Consulta Curso </h1>
	<br><br>
	<form action="ConsultarCurso" method="post">
		<div class="form-row" id="nombres">
			<div class="MyDiv" id="ins">
	    		<input class="form-check-input" type="checkbox" id="checkInstituto" name="esInstitutoInfoCurso" checked>
	    		<label class="form-check-label" for="checkInstituto" style="font-size: 150%">Instituto</label>
	    	</div>
	    </div>
	    <div class="form-row" id="nombres">
	    	<div class="MyDiv" id="cat">
	    		<input class="form-check-input" type="checkbox" id="checkCategoria" name="esCategoriaInfoCurso">
		    	<label class="form-check-label" for="checkCategoria" style="font-size: 150%">Categoria</label>
	    	</div>
	  	</div>
	  	<div class="form-row" id="nomIns">
	  		<div class="MyDiv" Style="display:block; margin:auto; width:80%; ">
		    	<input type="text" name="instituto-categoria" class="form-control" id="instituto-categoria" required>
	    	</div>
	    	<br></br>
	  	</div>
	  	<div id="nomInsAceptar">
	    	<button class="btn btn-primary" id="botonInsCat" type="submit" Style="display:block; margin:auto;">Aceptar</button>
	    </div>
	</form>
	<br></br>
	<form action="ConsultarCurso" method="post">
	   <div class="form-row">	
	      <div class="MyDiv" style="display:block; margin:auto;">
		      <select id="dropdownCursos" name="dropdownCursos" class="selectpicker" required>
		      	<option></option>
		        <%for(String c: cursosConsulta){%>
					<option value="<%=c %>"><%= c %></option><%
				}%>
		      </select>
		  </div>
		</div>
		<br>
		<div class="MyDiv" >
			<button class="btn btn-secondary"  type="submit" Style="display:block; margin:auto;">Buscar</button>
		</div>
	</form> 
		  		
	<br>	
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
					</tr>
					<tr>
						<th scope="row">Previas</th>
						<td><%=infoCurso.get(7) %></td>
					</tr>
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
			  	<%
			  	sesion.setAttribute("cursoConsultaEdicion", sesion.getAttribute("cursoConsulta").toString());
			  	sesion.setAttribute("optConsultaEdicionInfoEdicion", 5);
			  	%>
		      	<button type="submit" class="btn btn-secondary" id="buscarCursos" style="margin-left:10%">Consultar</button>
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