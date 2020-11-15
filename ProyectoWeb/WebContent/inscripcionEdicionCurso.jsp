<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "/header.jsp" %>
<title>Inscripcion a Edicion</title>
</head>
<body>
<form action="InscripcionEdicionCurso" method="post">
   <div class="form-row" id="divins">
    <div class="col-md-6 mb-3">
      <label for="validationDefault04">Institutos</label>
      <select class="custom-select" id="selectInstitutos" name="selectInstitutos"> <!-- onChange="cargarSinBoton();"> -->
        <option selected disabled value="">Choose...</option>
      </select>
       <button class="btn btn-secondary" type="button" id="boton1" onclick="cargarInstitutos();">Mostrar institutos</button>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault04">Cursos</label>
      <select class="custom-select" id="selectCursos" name="selectCursos">
        <option selected disabled value="">Choose...</option>
      </select>
      <button class="btn btn-secondary" type="button" id="boton2" onclick="cargarCursos();">Mostrar cursos</button>
    </div>
  </div>
  <h3 id="result"></h3>
  <button class="btn btn-primary" type="submit">Inscribirse</button>
</form>
	<!-- <h3 id="result"></h3> -->
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
	/*function imprimirInstitutos() {
		$(document).ready(function(){
			  $("#boton1").click(function(){ // Evento click del boton con id boton1
			    $.get("InscripcionEdicionCurso", function(data, status){ // hago el get al serverlet InscripcionEdicionCurso
			    	// data son los datos que devuelve, status es el resultado de la solicitud
			      alert("Data: " + data[0].nombre + "\nStatus: " + status); //imprimo un mensaje con el primer valor del JSON
			      alert("Data: " + data[1].nombre + "\nStatus: " + status);
			      document.getElementById("validationDefault04").innerHTML = data[1].nombre;
			    });
			  });
			});
	}
	*/
/*
	// Cargar institutos sin boton
	$(document).ready(function() {             // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		$('#selectInstitutos').change(function() {    
			$.get("InscripcionEdicionCurso", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
		        var $select = $("#selectInstitutos");                         // Locate HTML DOM element with ID "someselect".
		        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
		         //$('#selectInstitutos').append(`<option selected disabled value="${'Elige un instituto'}"> ${'Elige un instituto'} </option>`);
		        $.each(responseJson, function(value, result) {               // Iterate over the JSON object.
		        	$("<option>").text(result.nombre).appendTo($select); 
		        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
		        });
		    });
		});
	});
	*/
	/*
	// Cargar cursos sin boton
	function cargarSinBoton() {
		$(document).ready(function() { 
			$('#selectInstitutos').change(function() { 
				var instituto=$("#selectInstitutos :selected").text();
			 	//var instituto=$("#selectInstitutos :selected").val(); // obtiene el valor del select seleccionado
				//var instituto=$('#inputInstituto').val(); // creo variable con el valor del input usando su id
				$.ajax({ // Request Asincronica AJAX
					url: 'InscripcionEdicionCurso', // Serverlet
					method: 'POST',					// Metodo
					data: {institutoselect : instituto}, // los datos que voy a mandar, nombre del atributo : el valor
					success: function(resultText){ // si sale bien el request
						var $select = $("#selectCursos");                         // Locate HTML DOM element with ID "someselect".
				        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
				        //$('#selectCursos').append(`<option value="${optionValue}"> ${optionText} </option>`); Crear un option personalizado
				        //$('#selectCursos').append(`<option selected disabled value="${'Elige un curso'}"> ${'Elige un curso'} </option>`);
				        $.each(resultText, function(value, result) {               // Iterate over the JSON object.
				        	$("<option>").text(result).appendTo($select); 
				        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
				        });
						//$('#result').html(resultText); // muestro los datos en el h3 usando su id para identificarlo
					},
					error: function(jqXHR, exception){ // si da error el request
					console.log('Error occured!!'); // imprimo en la consola del navegador
					}
				});
			});
		});
	});
	*/
	/*
	$(document).ready(function() {
		//$('#selectInstitutos').load(function(){
			$.get("InscripcionEdicionCurso", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
		        var $select = $("#selectInstitutos");                         // Locate HTML DOM element with ID "someselect".
		        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
		         //$('#selectInstitutos').append(`<option selected disabled value="${'Elige un instituto'}"> ${'Elige un instituto'} </option>`);
		        $.each(responseJson, function(value, result) {               // Iterate over the JSON object.
		        	$("<option>").text(result.nombre).appendTo($select); 
		        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
		        });
		    });
		//});
	});
	*/
	/*
	$(document).ready(function() {
		$( "#result" ).text( "The DOM is now loaded and can be manipulated." );
		$(document).on("click", "#boton1", function() { 
		//$('#selectInstitutos').focus(function(){
			$.get("InscripcionEdicionCurso", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
		        var $select = $("#selectInstitutos");                         // Locate HTML DOM element with ID "someselect".
		        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
		         //$('#selectInstitutos').append(`<option selected disabled value="${'Elige un instituto'}"> ${'Elige un instituto'} </option>`);
		        $.each(responseJson, function(value, result) {               // Iterate over the JSON object.
		        	$("<option>").text(result.nombre).appendTo($select); 
		        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
		        });
		    });
		});
	});
	*/
	function cargarInstitutos() {
		$(document).on("click", "#boton1", function() {               // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		    $.get("InscripcionEdicionCurso", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
		        var $select = $("#selectInstitutos");                         // Locate HTML DOM element with ID "someselect".
		        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
		         //$('#selectInstitutos').append(`<option selected disabled value="${'Elige un instituto'}"> ${'Elige un instituto'} </option>`);
		        $.each(responseJson, function(value, result) {               // Iterate over the JSON object.
		        	$("<option>").text(result.nombre).appendTo($select); 
		        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
		        });
		    });
		});
	}
	
	 // POST EN AJAX
	 function cargarCursos() {
		 	var instituto=$("#selectInstitutos :selected").text();
		 	//var instituto=$("#selectInstitutos :selected").val(); // obtiene el valor del select seleccionado
			//var instituto=$('#inputInstituto').val(); // creo variable con el valor del input usando su id
			$.ajax({ // Request Asincronica AJAX
				url: 'InscripcionEdicionCurso', // Serverlet
				method: 'POST',					// Metodo
				data: {institutoselect : instituto}, // los datos que voy a mandar, nombre del atributo : el valor
				success: function(resultText){ // si sale bien el request
					var $select = $("#selectCursos");                         // Locate HTML DOM element with ID "someselect".
			        //$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
			        //$('#selectCursos').append(`<option value="${optionValue}"> ${optionText} </option>`); Crear un option personalizado
			        //$('#selectCursos').append(`<option selected disabled value="${'Elige un curso'}"> ${'Elige un curso'} </option>`);
			        $.each(resultText, function(value, result) {               // Iterate over the JSON object.
			        	$("<option>").text(result).appendTo($select); 
			        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
			        });
					//$('#result').html(resultText); // muestro los datos en el h3 usando su id para identificarlo
				},
				error: function(jqXHR, exception){ // si da error el request
				console.log('Error occured!!'); // imprimo en la consola del navegador
				}
			});
	 }
	
	// Ejemplo para cargar institutos en el Registrar 
	//if (document.getElementById("docente").checked) {
	 function cargarSelect(){
	 	if($("docente").prop("checked")) {
	 	$(document).ready(function(){
	 		  $("#boton1").click(function(){ // Evento click del boton con id boton1
	 		    $.get("AltaUsuario", function(data, status){ // hago el get al serverlet InscripcionEdicionCurso
	 		    	var $select = $("#selectInstituto");                         // Locate HTML DOM element with ID "someselect".
	 		        $select.find("option").remove();                     // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
	 		        $.each(data, function(value, result) {               // Iterate over the JSON object.
	 		   			$("<option>").text(result.nombre).appendTo($select); 
	 		        	//$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
	 		        });
	 		    });
	 		  });
	 	 });
	 	}
	 }
	 
</script>

<%@include file = "/footer.jsp" %>
</body>
</html>