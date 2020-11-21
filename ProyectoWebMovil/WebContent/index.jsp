<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<title>Stark Institutes</title>

<style>
	#listaInstitutos{
		display:block;
		margin:auto;
		width: 85%;
		border: 3px solid #222222;
	}
	
	#carouselExampleIndicators{
		display:block;
		margin:auto;
		width: 85%;
		border: 3px solid #222222;
	}
</style>

<%
HttpSession session = (HttpSession) request.getSession();
ArrayList<String> institutosIndex = (ArrayList) session.getAttribute("institutosPlataforma");
ArrayList<String> categoriasIndex = (ArrayList) session.getAttribute("categoriasPlataforma");
%>
</head>
<%@include file = "/header.jsp" %>
<br></br>
<body>
	<div class="list-group" id="listaInstitutos">
		<h4 align=center>Institutos</h4>
			<%if (institutosIndex != null) { 
			for(String ins: institutosIndex) { %>
				<a href="#" class="list-group-item list-group-item-action"><%=ins %></a>
			<%}
			
			}%>
			<br></br>
		<h4 align=center>Categorias</h4>
			<%if (categoriasIndex != null) { 
			for(String cat: categoriasIndex) { %>
				<a href="#" class="list-group-item list-group-item-action"><%=cat %></a>
			<%}
			
			}%>
	</div>
	<br>
	
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="imagenes/tercera.jpg" class="d-block w-100" alt="Stark Institutes">
	    </div>
	    <div class="carousel-item">
	      <img src="imagenes/segunda.jpg" class="d-block w-100" alt="Stark Institutes">
	    </div>
	    <div class="carousel-item">
	      <img src="imagenes/primera.jpg" class="d-block w-100" alt="Stark Institutes">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	
	<%@include file = "/footer.jsp" %>
</body>


</html>