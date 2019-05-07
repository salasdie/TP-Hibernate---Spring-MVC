<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Escriba un texto y elija una operacion</h1>
			<form action='operacion-validar' method="get">
			  <div class="form-group">
			    <label for="cadena">Texto</label>
			    <input type="text" class="form-control" id="cadena" name="cadena">
			  </div>
			  <div class="form-check">
				  <input class="form-check-input" type="radio" name="operacion" id="pasarAMayuscula" value="pasarAMayuscula">
				  <label class="form-check-label" for="pasarAMayuscula">
				    Pasar a mayuscula
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="operacion" id="pasarAMiniscula" value="pasarAMiniscula">
				  <label class="form-check-label" for="pasarAMiniscula">
				    Pasar a minuscula
				  </label>
				</div>
				<div class="form-check disabled">
				  <input class="form-check-input" type="radio" name="operacion" id="invertirOrden" value="invertirOrden">
				  <label class="form-check-label" for="invertirOrden">
				    Invertir orden
				  </label>
				</div>
				<div class="form-check disabled">
				  <input class="form-check-input" type="radio" name="operacion" id="cantidadDeCaracteres" value="cantidadDeCaracteres">
				  <label class="form-check-label" for="cantidadDeCaracteres">
				    Cantidad de caracteres
				  </label>
				</div>
			  <button type="submit" class="btn btn-primary">Consultar</button>
			</form>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>