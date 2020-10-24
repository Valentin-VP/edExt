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

<%@include file = "/footer.jsp" %>
</body>
</html>