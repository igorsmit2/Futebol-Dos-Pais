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
			<form action="inserir_campeonato" method="post">
			<p class=" titulo">Criar Campeonato</p>
			<hr>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<label for="nome"><b>Nome do Campeonato:</b></label>
                    	<input type="text" class="form-control input-radius" name="nome" id="nome" required maxlength="45" placeholder="Digite aqui o nome do campeonato">
					</div>
					<div class="col-md-6">
  						<label for="quantidade"><b>Quantidade de Times:</b></label>
                    	<select type="text" class="form-control input-radius" name="quantidadeTimes">
  							<option value="2">2</option>
  							<option value="4">4</option>
  							<option value="6">6</option>
  							<option value="8">8</option>
  							<option value="10">10</option>
  							<option value="12">12</option>
  							<option value="14">14</option>
  							<option value="16">16</option>
  							<option value="18">18</option>
  							<option value="20">20</option>
  						</select>
					</div>
                </div>
                <br>
                <div class="row">
					<div class="col-md-3">
						<label for="vitoria"><b>Pontos por Vitória:</b></label>
                    	<input type="number" class="form-control input-radius" name="pontosVitoria" id="vitoria" required maxlength="45" placeholder="">
					</div>
					<div class="col-md-3">
						<label for="empate"><b>Pontos por Empate:</b></label>
                    	<input type="number" class="form-control input-radius" name="pontosEmpate" id="empate" required maxlength="45" placeholder="">
					</div>
					<div class="col-md-3">
						<label for="derrota"><b>Pontos por derrota:</b></label>
                    	<input type="number" class="form-control input-radius" name="pontosDerrota" id="derrota" required maxlength="45" placeholder="">
					</div>
					<div class="col-md-3">
						<label for="derrota"><b>Turnos:</b></label>
                    	<select type="text" class="form-control input-radius" name="quantidadeTurno">
  							<option value="1">1</option>
  							<option value="2">2</option>
  						</select>
					</div>
                </div>
                <br>
                <div id="btn-center" class="row">
                	<div class="col-md-4"></div>
                	<div class="col-md-4">
	                	<a href="tela_campeonatos" class="btn btn-outline-success btn-modal">Voltar</a>
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