<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="index.jsp">edExt</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
				</a>
			</li>
			<li class="nav-item">
				<!-- Button trigger modal -->
				<a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModalCenter">
				  Agregar instituto
				</a>
				
				<!-- Modal -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLongTitle">Alta Instituto</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				       	 <div class="col-md-10">
					      <label for="nombreIntituto">Instituto</label>
					      <input type="text" class="form-control" id="nombreIntituto" required>
					    </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				        <button type="button" class="btn btn-primary">Aceptar</button>
				      </div>
				    </div>
				  </div>
				</div>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Agregar Usuario</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Agregar Curso</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Inscripciones</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Consultas</a>
			</li>
		</ul>
	</div>
</nav>