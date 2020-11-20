<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Stark Institutes</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
h3 { 
    display: relative;
}
</style>

<body>

<div class="container" align=center>
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                 <h2><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> ${mensaje} <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"> </span></h2> 
                <div class="error-details">
                    Sorry, an error has occured!
                </div>
                <img src="imagenes/roll-eyes.gif" class="d-block w-100"  alt="Stark Institutes" style="max-width:95%;max-height:95%; display:block; margin-left:auto; margin-right:auto;">
                <div class="error-actions">
                </div>
            </div>
        </div>
    </div>
    <br><br>
	<a href="RefreshInicio" class="btn btn-danger btn-lg">
		<span class="glyphicon glyphicon-home"></span> Home 
	</a>
</div>




</body>
</html>