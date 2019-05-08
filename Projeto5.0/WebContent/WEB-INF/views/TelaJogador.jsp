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
		<div id="titulo" class="container">
			<form action="buscar_jogadores" method="post">
			<p class=" titulo">Jogadores</p>
			<hr>
			<div class="container">
				
				<div class="row">
					<div class="col-md-3">
						<a href="tela_administrador" class="btn btn-outline-success btn-modal">Voltar</a>
					</div>
					 <div class="col-md-6">
						<div class="input-group mb-3">
  							<input type="text" class="form-control input-radius" name="chave" placeholder="Pesquisar Jogadores (deixe vazio para trazer todos)" aria-describedby="button-addon2">
  							<div class="input-group-append">
    							<button class="btn btn-outline-success input-radius" type="submit" id="button-addon2"><i class="fa fa-search"></i></button>
  							</div>
						</div>
                    </div>
					<div class="col-md-3 text-right">
						<a href="novo_jogador" class="btn btn-success btn-modal">Novo Jogador</a>
					</div>
				</div>
			</div>
			<hr>
			</form>
		</div>
		<br>

		<div class="container">
			<div class="row">
				<c:if test="${not empty listaJogadores}">
					<table id="tableFutebol" class="table">
  						<thead class="thead">
   	 						<tr>
						        <th scope="col">Foto</th>
						        <th scope="col">Apelido</th>
						        <th scope="col">Time</th>
						        <th scope="col">Categoria</th>
						        <th scope="col">Posicao</th>
						        <th scope="col">Capitao</th>
						        <th scope="col">Ações</th>
    						</tr>
  						</thead>
  						<tbody>
  							<c:forEach var="jogador" items="${listaJogadores}">
    						<tr>
							    <th scope="row"><img src="${jogador.fotoJogador}" height="48" width="48" class="img-thumbnail"></th>
							    <td>${jogador.apelido}</td>
							    <td>${jogador.time.nome}</td>
							    <td>${jogador.categoria.nome}</td>
							    <td>${jogador.posicao.nome}</td>
							    <td>
							    	<c:if test="${jogador.capitao == true}">
							    		Sim
							    	</c:if>
							    	<c:if test="${jogador.capitao == false}">
							    		Não
							    	</c:if>
								</td>
							    <td><a class="btn btn-success btn-sm btn-modal" href="visualizar_jogador?id=${jogador.id}">Visualizar</a></td>
    						</tr>
    						</c:forEach>
  						</tbody>
					</table>
				</c:if>
			</div>
		</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>