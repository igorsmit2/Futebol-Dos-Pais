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
			<hr>
			<p class=" titulo">Futebol dos Pais</p>
			<hr>
		</div>
		<br>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div id="card" class="card">
  						<img class="card-img-top img-responsive" src="img/barrier.png" alt="Card image cap">
  						<div class="card-body">
	    					<h3 class="card-title">Times</h3>
	   		 				<p class="card-text">Clique no botão abaixo para criar novos times, organizá-los e etc.</p>
	    					<a href="tela_time" class="btn btn-success btn-modal">Clique aqui!</a>
  						</div>
					</div>	
				</div>
				<div class="col-md-4">
					<div id="card" class="card">
  						<img class="card-img-top img-responsive" src="img/playoff.png" alt="Card image cap">
  						<div class="card-body">
	    					<h3 class="card-title">Campeonatos</h3>
	   		 				<p class="card-text">Clique no botão abaixo para criar novos campeonatos, organizá-los e etc.</p>
	    					<a href="tela_campeonatos" class="btn btn-success btn-modal">Clique aqui!</a>
  						</div>
					</div>	
				</div>
				<div class="col-md-4">
					<div id="card" class="card">
  						<img class="card-img-top img-responsive" src="img/soccer-player.png" alt="Card image cap">
  						<div class="card-body">
	    					<h3 class="card-title">Jogadores</h3>
	   		 				<p class="card-text">Clique no botão abaixo para criar novos jogadores, organizá-los e etc.</p>
	    					<a href="tela_jogador" class="btn btn-success btn-modal">Clique aqui!</a>
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