<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Area Cliente</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="contenido">
	<jsp:include page="MenuCliente.jsp" />
	<br><h1>Vista Cliente</h1>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>