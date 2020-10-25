<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stark Institutes</title>
</head>
<body>

<div class="container" align=center>
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    ${mensaje}</h2>
                <div class="error-details">
                    Sorry, an error has occured!
                </div>
                <img src="imagenes/roll-eyes.gif" class="d-block w-100" alt="Stark Institutes">
                <div class="error-actions">
                    <a href="RefreshInicio" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>