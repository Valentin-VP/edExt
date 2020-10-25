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
	if(session.getAttribute("optAltaCurso") == null){
		session.setAttribute("optAltaCurso", request.getParameter("optAltaCurso"));
	}
	
	@SuppressWarnings("unchecked")
	ArrayList<String> previas = (ArrayList) session.getAttribute("previasAltaCurso");
	ArrayList<String> categorias = (ArrayList) session.getAttribute("categoriasAltaCurso");
	if(previas == null){
		previas = new ArrayList<String>();
	}
	
	if(categorias == null){
		categorias = new ArrayList<String>();
	}

%>

<%if (session.getAttribute("optAltaCurso").toString().equals("inicio")){ %>
<form action="AltaCurso" method="post">
	<h1 align="center">Instituto</h1>
	<br><br>
   	<div class="form-row">	
      <div class="form-group col-md-10">
	      <input type="text" name="institutoAltaCurso" class="form-control" id="institutoAltaCurso">
	   </div>
	   <button type="submit" class="btn btn-primary">Nuevo Curso</button>
   	</div>   
</form> 

<%}else if(session.getAttribute("optAltaCurso").toString().equals("cargaDatos")) { %>
<form action="AltaCurso" method="post">
	<div class="container">
	  <div class="row">
		    <div class="col-sm">
		      
		      	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Instituto</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="StarkInstitutes" aria-label="Username" aria-describedby="basic-addon1" name=institutoAltaCurso>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Nombre</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="Tony Stark" aria-label="Username" aria-describedby="basic-addon1" name=cursoAltaCurso>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Descripcion</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="The best hero" aria-label="Username" aria-describedby="basic-addon1" name=descripcionAltaCurso>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Duracion</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="0" aria-label="Username" aria-describedby="basic-addon1" name=duracionAltaCurso>
		</div>
	</div>	
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Cantidad Horas</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="0" aria-label="Username" aria-describedby="basic-addon1" name=cantHorasAltaCurso>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">Creditos</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="0" aria-label="Username" aria-describedby="basic-addon1" name=creditosAltaCurso>
		</div>
	</div>
	
	<div class="form-row">
		<div class="input-group mt-2 mb-3">
	  		<div class="input-group-prepend">
	    		<span class="input-group-text" id="basic-addon1">URL</span>
	  		</div>
	  		<input type="text" class="form-control" placeholder="www" aria-label="Username" aria-describedby="basic-addon1" name=urlAltaCurso>
		</div>
	</div>
		      
	    </div>
	    <!-- Segunda columna -->
	    <div class="col-sm">
	    
	      <div class="form-row">
			<div class="form-group col-md-6">
	    	  <label for="inputCategorias">Seleccione Categorias</label>
	 		     <select id="inputCategorias" name="categoriasAltaCurso" class="selectpicker" multiple="multiple">
	     		   <%for(String c: categorias){ %>
	    		    <option value="<%= c %>"><%= c %></option>
	  			   <%} %>
	 		     </select>
	  		  </div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
	    		  <label for="inputCategorias">Seleccione Previas</label>
	 		  		<select id="inputPrevias" name="previasAltaCurso" class="selectpicker" multiple="multiple">
			     		   <%for(String p: previas){ %>
			    		    <option value="<%= p %>"><%= p %></option>
			  			   <%} %>
	 		  		</select>
	  		 	 </div>
	  		</div>
			
	    </div>
	    <!-- Fin segunda columna -->
	  </div>
	</div>
	<div class="form-row"  align="center">
		<div class="col-sm">
			<button type="submit" class="btn btn-primary">Dar de Alta</button>
		</div>
	</div>
</form>
<%} %>

<%@include file = "/footer.jsp" %>
</body>
</html>