<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "/header.jsp" %>
<title>Insert title here</title>
</head>
<body>

<form action="InscripcionEdicionCurso" method="post">
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">Instituto</label>
      <input type="text" class="form-control" id="inputInstituto"name="instituto" placeholder="Fing" required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault04">Cursos</label>
      <select class="custom-select" id="validationDefault04" required>
        <option selected disabled value="">Choose...</option>
        <option>Calculo 2</option>
      </select>
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit form</button>
</form>

<div id="mostrardatos">
	<button id="boton1" onclick="imprimirInstitutos();">Mostrar institutos</button>
	<button id="boton2" onclick="imprimirCursos();">Mostrar primer curso</button>
	<h3 id="result"></h3>
</div>

<script>

	// GET en AJAX, CREA una tabla con la lista de objetos JSON
	//Returning List<Entity> as JSON
	//$(document).on("click", "#somebutton", function() {        // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	//    $.get("someservlet", function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
	//        var $table = $("<table>").appendTo($("#somediv")); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
	//        $.each(responseJson, function(index, product) {    // Iterate over the JSON array.
	//            $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
	//                .append($("<td>").text(product.id))        // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
	//                .append($("<td>").text(product.name))      // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
	//                .append($("<td>").text(product.price));    // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
	//        });
	//    });
	//});
	
	// GET EN AJAX
	//Returning List<String> as JSON
	function imprimirInstitutos() {
		$(document).ready(function(){
			  $("#boton1").click(function(){ // Evento click del boton con id boton1
			    $.get("InscripcionEdicionCurso", function(data, status){ // hago el get al serverlet InscripcionEdicionCurso
			    	// data son los datos que devuelve, status es el resultado de la solicitud
			      alert("Data: " + data[0].nombre + "\nStatus: " + status); //imprimo un mensaje con el primer valor del JSON
			      alert("Data: " + data[1].nombre + "\nStatus: " + status);
			    });
			  });
			});
	}
	
	 // POST EN AJAX
	 function imprimirCursos() {
			var instituto=$('#inputInstituto').val(); // creo variable con el valor del input usando su id
			$.ajax({ // 
				url: 'InscripcionEdicionCurso', // Serverlet
				method: 'POST',					// Metodo
				data: {instituto : instituto}, // los datos que voy a mandar, nombre del atributo : el valor
				success: function(resultText){ // si sale bien el request
				$('#result').html(resultText); // muestro los datos en el h3 usando su id para identificarlo
				},
				error: function(jqXHR, exception){ // si da error el request
				console.log('Error occured!!'); // imprimo en la consola del navegador
				}
			});
	 }
	
</script>

<%@include file = "/footer.jsp" %>
</body>
</html>