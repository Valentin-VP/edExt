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
<title>Stark Institutes</title>

<%
HttpSession session = (HttpSession) request.getSession();
session.setAttribute("inicio", null);
//ArrayList<String> institutosIndex = (ArrayList) session.getAttribute("institutosPlataforma");
//ArrayList<String> categoriasIndex = (ArrayList) session.getAttribute("categoriasPlataforma");
%>
<%@include file = "/header.jsp" %>

<%@include file = "/footer.jsp" %>
</body>


</html>