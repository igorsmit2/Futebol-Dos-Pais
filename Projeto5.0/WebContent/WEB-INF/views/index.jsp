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

    	<title>Futebol dos Pais</title>
  	</head>
  	<body>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  			<div class="modal-dialog modal-dialog-centered" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h3 class="modal-title modal-center" id="exampleModalCenterTitle">Login</h3>
      				</div>
      				<div class="modal-body">
      					<div class="container">
        					<form action="fazer_login" method="post">
        						<div class="row">
        							<div class="col-md-2">
        							</div>
        							<div class="from-group col-md-8">
	        							<label for="email"><h5>E-mail</h5></label>
				        				<div class="input-group">
				  							<div class="input-group-prepend">
				    							<span class="input-group-text input-radius" id="basic-addon1"><i class="fa fa-envelope"></i></span>
				  							</div>
				  							<input name="username" type="text" class="form-control input-radius" placeholder="Ex: ronaldo@ronaldo.com" id="email">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
        							</div>
        							<div class="from-group col-md-8">
        								<br />
	        							<label for="senha"><h5>Senha</h5></label>
				        				<div class="input-group">
				  							<div class="input-group-prepend">
				    							<span class="input-group-text input-radius" id="basic-addon1"><i class="fa fa-key"></i></span>
				  							</div>
				  							<input name="password" type="password" class="form-control input-radius" placeholder="Digite sua senha" id="senha">
										</div>
									</div>
								</div>
						</div>
      				</div>
      				<div class="modal-footer text-center modal-center">
      					<button type="submit" class="btn btn-modal btn-success">Login</button>
        				<button type="button" class="btn btn-modal btn-secondary" data-dismiss="modal">Close</button>
      				</div>
      				</form>
    			</div>
  			</div>
		</div>

		<!-- NAVBAR -->
		<nav id="menu" class="navbar navbar-expand-lg navbar-dark">
  			<div class="container">
	  			<a class="navbar-brand" href="index">Futebol dos Pais</a>
	  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    			<span class="navbar-toggler-icon"></span>
	  			</button>

	  			<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    			<ul class="navbar-nav mr-auto">
	      				<li class="nav-item">
	        				<a class="nav-link" href="#">Campeonatos<span class="sr-only">(current)</span></a>
	      				</li>
	      				<li class="nav-item">
	        				<a class="nav-link" href="#">Times</a>
	      				</li>
	    			</ul>
	    			<ul class="navbar-nav ml-auto">
	    				<li class="nav-item"><a href="" class="nav-link" data-toggle="modal" data-target="#exampleModalCenter">Login</a></li>
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

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>