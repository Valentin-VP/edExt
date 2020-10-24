<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Script necesario para utilizar jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>JQuery AJAX Example</h2>
Enter your name:
<input type="text" id="name"/><br/>
<button onclick="callJqueryAjax()">Submit</button>
<br/><br/>
<h3 id="result"></h3>
<!-- funcion para usar AJAX -->
<script type="text/javascript">
function callJqueryAjax(){
	var name=$('#name').val(); // creo variable con el valor del input
	$.ajax({ // 
		url: 'AJAXexample', // Serverlet
		method: 'POST',
		data: {name : name},
		success: function(resultText){ // si sale bien el request
		$('#result').html(resultText); // muestro los datos en el h3
		},
		error: function(jqXHR, exception){ // si da error el request
		console.log('Error occured!!'); // imprimo en la consola del navegador
		}
	});
}
</script>
</body>
</html>