<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inicial-scale=1, shrink-to-fit=no">
<%@include file = "/header.jsp" %>
<title>Crear una nueva edicion para un curso</title>
</head>
<body>
<% 	
	HttpSession s = (HttpSession) request.getSession();
	@SuppressWarnings("unchecked")
	ArrayList<String> docentes = (ArrayList<String>) s.getAttribute("docentes");
	@SuppressWarnings("unchecked")
	ArrayList<String> cursos = (ArrayList<String>) s.getAttribute("cursos");

	if(s.isNew() || cursos == null) {%>
<form action="IngresoInstitutoAltaEdicion" method="post"> <!-- me traigo los cursos y los docentes del instituto -->
   <div class="form-row">	
      <div class="form-group col-md-4">
	      <label for="inputInstituto">Instituto</label>
	      <select id="inputInstituto" name="instituto" class="form-control">
	        <option selected>Choose...</option>
	        <option value="crandon">Crandon</option>
	      </select>
	   </div>
	   <button type="submit" class="btn btn-primary">Buscar Cursos</button>
   </div>   
</form>    
<%} else  {%>
<!-- otro formulario con el resto del caso de uso -->
<% } %>
<%@include file = "/footer.jsp" %>
</body>
</html>