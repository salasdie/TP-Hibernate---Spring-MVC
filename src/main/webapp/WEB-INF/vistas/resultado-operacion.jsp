<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta content="text/html">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>El resultado de su operacion es:</h1>
			<% if ("cantidadDeCaracteres".equals(request.getParameter("operacion"))) { %>
        		<h4>El resultado de ${operacion} sobre ${cadena} es ${resultado}, donde ${resultado} es la cantidad de caracteres de la cadena recibida por parametro</h4>
    		<% } else { %>
        		<h4>El resultado de ${operacion} sobre ${cadena} es ${resultado}, donde ${resultado} es la cadena resultante de aplicar la operacion a la cadena recibida por parametro</h4>
    		<% } %>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>