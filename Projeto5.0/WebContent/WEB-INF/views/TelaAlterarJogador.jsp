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
									<div id="link-active"><a class="nav-link  active-nav" href="tela_alterar_jogador?id=${jogador.id}">Alterar Jogador</a></div>
									<a class="nav-link" href="tela_excluir_jogador?id=${jogador.id}">Excluir Jogador</a>
									<a class="nav-link" href="voltar_tela_jogador">Voltar</a>
								</nav>	
							</div>
						</div>

					</div>
				</div>
				<div  class="col-md-6">
					<form action="alterar_jogador" method="post">
					<div class="container-fluid">
						<div class="row">
							<div id="menuTime" class="col-md-12">
								<hr>
								<p class="titulo-visualizar">Alterar Jogador</p>
								<hr>
							</div>
						</div>
						<div class="row">
							<input type="hidden" class="form-control input-radius" name="id" id="id" value="${jogador.id }">
							<div class="col-md-6">
								<label for="apelido"><b>Apelido do Jogador:</b></label>
		                    	<input type="text" class="form-control input-radius" name="apelido" id="nome" value="${jogador.apelido }" required maxlength="45" placeholder="Digite aqui o apelido do jogador">
							</div>
							<div class="col-md-6">
		  						<label for="capitao"><b>Capitão:</b></label>
		  						<select type="text" class="form-control input-radius" name="capitao">
							    	<c:if test="${jogador.capitao == true}">
							    		<option value="true">Sim</option>
							    		<option value="false">Não</option>
							    	</c:if>
							    	<c:if test="${jogador.capitao == false}">
							    		<option value="false">Não</option>
							    		<option value="true">Sim</option>
							    	</c:if>
		  						</select>
							</div>
		                </div>
		                <br>
		                <div class="row">
							<div class="col-md-6">
								<label for="fotoJogador"><b>Foto do Jogador:</b></label>
		                    	<input type="text" class="form-control input-radius" name="fotoJogador" value="${jogador.fotoJogador }"id="fotoJogador" required maxlength="45" placeholder="Caminho da imagem Ex:img/foto.png">
							</div>
							<div class="col-md-6">
		  						<label for="time"><b><b>Time:</b></b></label>
		                    	<select class="form-control input-radius" name="time.id" id="time">
		                    	<option value="${jogador.time.id }">${jogador.time.nome }</option>
				        		<c:forEach var="listaTimeSelect" items="${listaTimes}">
				        			<c:if test="${jogador.time.nome != listaTimeSelect.nome}">
				        				<option value="${listaTimeSelect.id}">${listaTimeSelect.nome}</option>
							    	</c:if>
				        		</c:forEach>
				        		</select>
							</div>
		                </div>
		                <br>
		                <div class="row">
							<div class="col-md-6">
								<label for="posicao"><b>Posição:</b></label>
				        		<select class="form-control input-radius" name="posicao.id" id="posicao">
		                    	<option value="${jogador.posicao.id }">${jogador.posicao.nome }</option>
				        		<c:forEach var="listaPosicaoSelect" items="${listaPosicao}">
				        			<c:if test="${jogador.posicao.nome != listaPosicaoSelect.nome}">
				        				<option value="${listaPosicaoSelect.id}">${listaPosicaoSelect.nome}</option>
							    	</c:if>
				        		</c:forEach>
				        		</select>
				        	</div>
				        	<div class="col-md-6">
				        		<label for="categoria"><b>Categoria:</b></label>
			        			<select class="form-control input-radius" name="categoria.id" id="categoria">
		                    	<option value="${jogador.categoria.id }">${jogador.categoria.nome }</option>
			        				<c:forEach var="listaCategoriaSelect" items="${listaCategoria}">
			        					<c:if test="${jogador.categoria.nome != listaCategoriaSelect.nome}">
				        					<option value="${listaCategoriaSelect.id}">${listaCategoriaSelect.nome}</option>
							    		</c:if>
			        				</c:forEach>
			        			</select>	
				        	</div>
			        	</div>
			        	<br>
		                <div id="btn-center" class="row">
		                	<div class="col-md-4"></div>
		                	<div class="col-md-4">
			                	<a href="tela_jogador" class="btn btn-outline-success btn-modal">Voltar</a>
			                	<button type="submit" class="btn btn-modal btn-success">Salvar</button>                	
		                	</div>
		                </div>			
					</div>
					</form>
				</div>
			</div>
		</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>