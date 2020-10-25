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
<%@include file = "/header.jsp" %>
<title>Stark Institutes</title>

<%
String session_val = (String) sesion.getAttribute("welcome"); 
System.out.println("session_val "+session_val);
ArrayList<String> institutosIndex = (ArrayList) sesion.getAttribute("institutosPlataforma");
ArrayList<String> categoriasIndex = (ArrayList) sesion.getAttribute("categoriasPlataforma");
%>

<%

if(session_val != null){%>

<style>

#carouselExampleIndicators{
	top: 50px;
	float: right;
 	margin: 0 1.5%;
	width: calc(70%);
	position : relative;
	border : 3px solid #FF0000;
}

#listaInstitutos {
	float: left;
	margin: 0 1.5%;
	width: 63%;
	position: relative;
	top: 50px;
	left: 0;
	height: 600px;
	border: 3px solid #FF0000;
	overflow: auto;
	visibility: hidden;
}

</style>

<%}else{%>
<style>

#carouselExampleIndicators{
	top: 50px;
	float: center;
 	margin: auto;
	width: calc(70%);
	position : relative;
	border : 3px solid #FF0000;
}

#listaInstitutos {
	float: left;
	margin: 0 1.5%;
	width: 63%;
	position: relative;
	top: 50px;
	left: 0;
	height: 600px;
	border: 3px solid #FF0000;
	overflow: auto;
	visibility: hidden;
}

</style>

<%} %>
</head>

<body>

<div id="listaInstitutos" class="list-group">
<h4 align=center>Institutos</h4>
	<%if (institutosIndex != null) { 
	for(String ins: institutosIndex) { %>
		<a href="#" class="list-group-item list-group-item-action"><%=ins %></a>
	<%}
	
	}%>
          <!-- Botton de prueba AJAX -->
<!--      <a class="list-group-item list-group-item-action" href="AJAXexample.jsp">prueba AJAX</a> -->
<h4 align=center>Categorias</h4>
	<%if (categoriasIndex != null) { 
	for(String cat: categoriasIndex) { %>
		<a href="#" class="list-group-item list-group-item-action"><%=cat %></a>
	<%}
	
	}%>
</div>

<div id="welcome" data-prodnumber="${sessionScope.welcome}"> 
</div>

<script type="text/javascript">
	var session_obj= '<%=session_val%>';
       	if(session_obj != "null"){
	   		element = document.getElementById('listaInstitutos'); 
	        element.style.visibility = 'visible';
	        element.style.width = 'calc(20%)';
       	}else{
	   		element = document.getElementById('listaInstitutos'); 
	        element.style.visibility = 'hidden'; /* hidden */
	        element.style.width = '0px';
       	}
  
</script> 

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="imagenes/105.jpg" class="d-block w-100" alt="Stark Institutes">
    </div>
    <div class="carousel-item">
      <img src="imagenes/18409.jpg" class="d-block w-100" alt="Stark Institutes">
    </div>
    <div class="carousel-item">
      <img src="imagenes/19589.jpg" class="d-block w-100" alt="Stark Institutes">
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



<br><br><br>
<!-- <form action="CargarTodo" method="post">
	<div class="form-row" align="center">
		<button type="submit" class="btn btn-primary btn-lg">Acceder</button>
	</div>
</form> -->


<%@include file = "/footer.jsp" %>
</body>

<%-- <body>
               

 <script> 
	$(document).ready(function(){
  		//$("#cargarCombo").click(function(){
  		//$("#cargarCombo").on("click", function() {
		$.get("AltaUsuario", function(responseJson) {
    		//$.each(responseJson, function(index, instituto) {
  			//$("<option>").appendTo($("#inputInstituto")).text(instituto.nombre);      
  			//});
  			alert("Datos: " + responseJson);
  		});
  		//});
  	});	
</script>
<%@include file = "/footer.jsp" %>
</body> --%>
</html>