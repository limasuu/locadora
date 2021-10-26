<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8"/>
		<title>Locadora Virtual</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
	
		<header>
			<img width="5%" height="5%" src="icone.png"/>
			<h1>Locadora Virtual</h1>
			<img width="5%" height="5%" src="icone.png"/>		
		</header>
		
		<main>
			<p class="titulo">Locadora Virtual</p>
			<c:url var="url" value="/catalogo"/>
			
			<p><a href="${url}?Add=">Iniciar aluguel</a></p>
		</main>
		
		<footer>
			<p>Copyright 2021 - Locadora Virtual.</p>	
			<p>Ícones feitos por <a href="https://www.flaticon.com/br/autores/ayub-irawan" title="Ayub Irawan">Ayub Irawan</a> from <a href="https://www.flaticon.com/br/" title="Flaticon">www.flaticon.com</a></p>
		</footer>		
	
	</body>
</html>