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
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<div id="menuTime" class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<hr>
								<p class="titulo-visualizar">${jogador.apelido }</p>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<img src="${jogador.fotoJogador}" class="img-center img-responsive">
								
							</div>
						</div><br>
						<div class="row">
							<div class="col-md-12">
								<nav id="menuVisualizar" style="width: 100%;"class="nav flex-column">
									<a class="nav-link" href="visualizar_jogador?id=${jogador.id}">Home</a>
									<a class="nav-link" href="tela_alterar_jogador?id=${jogador.id}">Alterar Jogador</a>
									<div id="link-active"><a class="nav-link active-nav" href="tela_excluir_jogador">Excluir Jogador</a></div>
									<a class="nav-link" href="voltar_tela_jogador">Voltar</a>
								</nav>	
							</div>
						</div>

					</div>
				</div>
				<div id="menuTime" class="col-md-6">
					<div class="container-fluid">
						<div class="row">
							<div id="menuTime" class="col-md-12">
								<hr>
								<p class="titulo-visualizar">Excluir Jogador</p>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4"></div>
							<div id="menuTime" class="col-md-4">
								<h4>Você tem certeza que deseja excluir este Jogador?</h4>
								<br>
								<img src="${jogador.fotoJogador}" style="height: 80px; width: 80px;"class="img-center img-responsive">
								<br>
								<br>
								<a href="visualizar_jogador?id=${jogador.id}" class="btn btn-outline-success btn-modal">Não</a>
								<a href="excluir_jogador?id=${jogador.id}" class="btn btn-danger btn-modal">Sim</a>
							</div>
						</div>
							</div>
						</div>
					</div>			
				</div>
			</div>
		</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>