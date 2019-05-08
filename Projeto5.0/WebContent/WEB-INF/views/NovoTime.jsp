<!doctype html>
<html lang="pt-br">
 	<head>
    	<!-- Required meta tags -->
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    	<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    	<link rel="stylesheet" type="text/css" href="_css/style.css">
    	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    	<title>Futebol dos Pais - Administrador</title>
  	</head>
  	<body>
		<!-- NAVBAR -->
		<nav id="menu" class="navbar navbar-expand-lg navbar-dark">
  			<div class="container">
	  			<a class="navbar-brand" href="tela_administrador">Home</a>
	  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    			<span class="navbar-toggler-icon"></span>
	  			</button>

	  			<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    			<ul class="navbar-nav mr-auto">

	    			</ul>
	    			<ul class="navbar-nav ml-auto">
	    				<li class="nav-item"><a href="index" class="nav-link"><i class="fa fa-sign-out-alt"></i>Sair</a></li>
	    			</ul> 
	  			</div>
  			</div>
		</nav>
		<br>
		<div id="titulo" class="container">
			<form action="inserir_time" method="post">
			<p class=" titulo">Criar Time</p>
			<hr>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<label for="nome"><b>Nome do Time:</b></label>
                    	<input type="text" class="form-control input-radius" name="nome" id="nome" required maxlength="45" placeholder="Digite aqui o nome do time">
					</div>
					<div class="col-md-6">
  						<label for="emblema"><b>Emblema do Time:</b></label>
                    	<input type="text" class="form-control input-radius" name="emblema" id="emblema" required maxlength="45" placeholder="Caminho da Imagem Ex:img/foto.png">
					</div>
                </div>
                <br>
                <div class="row">
					<div class="col-md-6">
						<label for="coordenador"><b>Coordenador:</b></label>
                    	<input type="text" class="form-control input-radius" name="coordenador" id="coordenador" required maxlength="45" placeholder="Digite aqui o nome do Coordenador da equipe">
					</div>
					<div class="col-md-6">
  						<label for="fotoEquipe"><b>Foto da equipe:</b></label>
                    	<input type="text" class="form-control input-radius" name="fotoEquipe" id="fotoEquipe" required maxlength="45" placeholder="Caminho da Imagem da equipe Ex:img/foto.png">

					</div>
                </div>
                <br>
                <div id="btn-center" class="row">
                	<div class="col-md-4"></div>
                	<div class="col-md-4">
	                	<a href="tela_time" class="btn btn-outline-success btn-modal">Voltar</a>
	                	<button type="submit" class="btn btn-modal btn-success">Salvar</button>                	
                	</div>
                </div>
			</div>
			<hr>
			</form>
		</div>
		<br>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>