<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Profesional - Vista Administrador</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Editar infomación del profesional</h2>
	
	
	<form action="ProfEditar" method="post">
				<input type="hidden" name="idempleado"  value="${datosprofesional.getIdempleado()}" />
				<input type="hidden" name="idusuario"  value="${datosprofesional.getIdusuario()}" />
				<table class="tabla">
					<tr>   
						<td>Nombre:</td>
						<td><input type="text" name="nombre" value="${datosprofesional.getNombre()}"/></td>
					</tr>
					<tr>
						<td>Celular:</td>
						<td><input type="text" name="celular" value="${datosprofesional.getCelular()}"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Editar Profesional" /></td>
					</tr>
				</table>
			</form>
	
	
	
	<a class="boton" href="Profesionales"><i class="fas fa-undo-alt"></i> Volver a listado de profesionales</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>