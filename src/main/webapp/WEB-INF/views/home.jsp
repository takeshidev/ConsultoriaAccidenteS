<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home - Consultoria Accidentes</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="contenido">
	
	<h1>Bienvenido</h1><br>
	<h2>Men�</h2>
	<button onclick="window.location.href='AreaAdmin';" type="button" class="btn btn-outline-primary">Admin</button>
	<button onclick="window.location.href='AreaCliente';" type="button" class="btn btn-outline-primary">Cliente</button>
	<button onclick="window.location.href='AreaProfesional';" type="button" class="btn btn-outline-primary">Profesional</button>
		
		<h2>No m�s Accidentabilidad</h2>
		<h3>Integrantes</h3>
			<p>Takeshi Kita - <a target="_blank" href="https://github.com/takeshidev"><i class="fab fa-github"></i>takeshidev</a></p>
			<p>Crist�bal Latorre - <a target="_blank" href="https://github.com/toballatorre"><i class="fab fa-github"></i>toballatorre</a></p>
			<br>
		<h3>Tema:</h3>
		<p>Construir aplicaciones web din�micas utilizando el entorno de desarrollo Java.</p>
		<br>
		<h3>Objetivos del proyecto:</h3>
		<p>Interpretar especificaciones de sistemas utilizando casos de uso para su posterior implementaci�n
		Construir una aplicaci�n web din�mica utilizando el patr�n MVC con vistas JSP y controladores Servlets para el despliegue de informaci�n.
		Realizar conexi�n a una base de datos din�mica de acuerdo a las especificaciones entregadas</p>
		<br>
		<h3>Preparaci�n del proyecto</h3>
		<p>1. Iniciamos dise�ando el diagrama de casos de uso que se provey� en la asignaci�n del proyecto.</p>
		<img src="resources/img/DiagramasModelos/CasosDeUso.jpg">
		
		<p>2. Creamos el diagrama de casos</p>
		<img src="resources/img/DiagramasModelos/DiagramaCasodeUso.jpeg" width="90%">
		
		<p>3. Modelo de Datos</p>
		<p><a target="_blank" href="SQL/ScriptUnico.sql">Ver script base de datos</a></p>
		
		<img src="resources/img/DiagramasModelos/Relational_1.png" width="90%">
		
		<p>4. Secuencias</p>
		<img src="resources/img/DiagramasModelos/SecuanciaAdmin.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaCliente.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaProfesional.jpg" width="90%">
		
		<h3>GitHub</h3>
		<p><a target="blank" href="https://github.com/toballatorre/ConsultoriaAccidenteS.git">https://github.com/toballatorre/ConsultoriaAccidenteS.git</a></p>
		
</div>
<jsp:include page="footer.jsp" />

</body>
</html>
