<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
crossorigin="anonymous">

<!-- nuevo -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<%

	HttpSession sesion = (HttpSession) request.getSession();

	

	String tipoUser = (String) sesion.getAttribute("tipo");
	String nickname = (String) sesion.getAttribute("nick");
	String optConsultaCurso = "0";
	String optConsultaEdicion = "0";
	String optAltaEdicion = "0";
	String opAceptadosEdicion = "0";
	String optAltaCurso = "inicio";
	String opSeleccionarEstudiantes = "0";
	


if(sesion.getAttribute("inicio") == "iniciado") {  %>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #222222;">
  <a class="navbar-brand" href="RefreshInicio">edExt</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     <li class="nav-item dropdown">
     	<a class="nav-link dropdown-toggle" href="#" id="ConsultasDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Informacion
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        	<a class="dropdown-item" href='infoCurso.jsp?optConsultaCursoInfoCurso=<%= optConsultaCurso %>'>Curso</a>
          	<a class="dropdown-item" href='infoEdicion.jsp?optConsultaEdicionInfoEdicion=<%= optConsultaEdicion %>'>Ediciones</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="EstudiantesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Estudiantes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="inscripcionEdicionCurso.jsp">Inscribirse</a>
        </div>
      </li>
      <li class="nav-item">
       	<a class="nav-link" href="CerrarSesion" id="IniciarButton" role="button">Cerrar Sesion</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ConsultaUsuario.jsp" id="ConsultaUsuarios" role="button">Usuarios</a>
      </li>		
      <li class="nav-item">
        <a class="nav-link disabled" href="ConsultaUsuario.jsp" id="RegistrarseButton" role="button">Mi Perfil<%= " - " + nickname %></a>
      </li>
    </ul>
    <form action="FiltradoYBusqueda" method="post" class="form-inline my-2 my-lg-0">
      <input name="busqueda" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<%} else { //-- NavBar visitante -->
	String redirectURL = "/ProyectoWebMovil/inicioSesion.jsp";
	response.sendRedirect(redirectURL);
 } %>