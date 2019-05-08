<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<div id="menuTime" class="container">
				<div class="row">
					<div class="col-md-12">
						<hr>
						<p class="titulo-visualizar">Adicionar Time</p>
						<hr>
					</div>
				</div>
			</div>
			<div class="container">
				<form action="adicionar_time" method="post">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="hidden" name="idCampeonato" value="${campeonato.id }">
					  	<label for="time"><b>Time:</b></label>
                    	<select class="form-control input-radius" name="idTime" id="time">
                    	<option value="">- Escolha uma opção -</option>
		        		<c:forEach var="time" items="${listaTimes}">
		        			<option value="${time.id}">${time.nome}</option>
		        		</c:forEach>
		        		</select>					
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-4"></div>
					<div id="menuTime" class="col-md-4">
						<a href="tela_administrador" class="btn btn-outline-success btn-modal">Voltar</a>
	                	<button type="submit" class="btn btn-modal btn-success">Adicionar</button>  
					</div>
				</div>
				</form>
			</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>