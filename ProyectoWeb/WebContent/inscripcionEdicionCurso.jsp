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
    <div class="col-md-6 mb-3">
      <label for="validationDefault02">Curso</label>
      <input type="text" class="form-control" id="validationDefault02" placeholder="Calculo 2" required>
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
    <div class="col-md-3 mb-3">
      <label for="validationDefault04">State</label>
      <select class="custom-select" id="validationDefault04" required>
        <option selected disabled value="">Choose...</option>
        <option>...</option>
      </select>
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationDefault05">Zip</label>
      <input type="text" class="form-control" id="validationDefault05" required>
    </div>
  </div>
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
      <label class="form-check-label" for="invalidCheck2">
        Agree to terms and conditions
      </label>
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit form</button>
</form>

<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Dropdown link
  </a>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
  </div>
</div>

<div class="table-responsive">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</div>

<div id="mostrardatos">
<button id="boton1" onclick="imprimir();">Send an HTTP GET request to a page and get the result back</button>
</div>

<script>
	//function cargarDropDown() {
		
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
	
	//Returning List<String> as JSON
	function imprimir() {
		$(document).ready(function(){
			  $("#boton1").click(function(){
			    $.get("AltaUsuario.java", function(data, status){
			      alert("Data: " + data + "\nStatus: " + status);
			    });
			  });
			});
	}
	
	$(document).on("click", "#texto", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	    $.get("AltaUsuario.java", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
	        var $ul = $("<ul>").appendTo($("#mostrardatos")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
	        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
	            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
	        });
	    });
	});
	
	//}
</script>

<%@include file = "/footer.jsp" %>
</body>
</html>