<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>BEM VINDO AO FUTEBOLERIA</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 700px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 60px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 72px;
        line-height: 1;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="./bemvindo.jsp">Projeto Futeboleria</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link">${club.username}</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Link Rapido</li>
              <li class="active"><a href="#">Meu Perfil</a></li>
              <li><a href="./homeClub.jsp">Home</a></li>
              <li><a href="listarPlayers">Listar Players</a></li>
              <li><a href="./procurarJogador.jsp">Buscar Players</a></li>
              <li class="nav-header">Principais Noticias</li>
              <li><a href="#">Canal de Suporte</a></li>
              <li><a href="#">Atualizacoes e novidades</a></li>
              <li><a href="#">Peneiras</a></li>
              <li><a href="#">Fotos de eventos</a></li>
              <li><a href="#">Regulamento</a></li>
              <li><a href="#">Sobre o Futeboleria</a></li>
              <li class="nav-header">Parceiros</li>
              <li><a href="#">Terra Noticias</a></li>
              <li><a href="#">Globo Esporte</a></li>
              <li><a href="#">PeneirasOnline.com</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="hero-unit">
            <h1>Editar o Meu Perfil</h1>
            <form class="form-cadastro " action="salvarCadastroClub?id=${club.id}" method="post">
        <h2 class="form-cadastro-heading">Editar Dados Cadastrais Para Jogadores</h2>
        <input type="text" name="txtUsername" class="input-block-level" value="${club.username}" placeholder="Nome de Login">
        <input type="password" name="txtPassword" class="input-block-level" value="${club.password}" placeholder="Password">
        <input type="text" name="txtNome" class="input-block-level"  value="${club.nome}" placeholder="Nome">
        <input type="text" name="txtEmail" class="input-block-level"  value="${club.email}" placeholder="Email address">
        <input type="text" name="txtEndereco" class="input-block-level" value="${club.endereco}" placeholder="Endere��o">
        <input type="text" name="txtBairro" class="input-block-level"  value="${club.bairro}" placeholder="Bairro">
        <input type="text" name="txtCidade" class="input-block-level"  value="${club.cidade}" placeholder="Cidade">
        <input type="text" name="txtTelefone" class="input-block-level"  value="${club.telefone}" placeholder="Telefone">
        <input type="text" name="txtCpf" class="input-block-level" value="${club.cpf}" placeholder="CPF">
        
        <a href="homeClub.jsp" class="btn btn-large btn-success"> Tudo Esta Correto</a>
        <button class="btn btn-large btn-primary" value="alterar" name="btnAlterar" type="submit">Alterar</button>
        <a href="#excluirModal" role="button" class="btn btn-large btn-danger" data-toggle="modal">Excluir</a>
        <a href="homeClub.jsp" class="btn btn-large pull-right">Voltar</a>
        
      </form>
            
<!-- Button to trigger modal --> 
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	    $(window).load(function(){
	        $('#myModal').modal('show');
	    });
	</script>
	<script src="js/bootstrap.js"></script>
     
    <!-- Inicio do Modal -->
<div id="excluirModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    		<h3 id="myModalLabel">Tem certeza que deseja excluir ?</h3>
    	</div>
    	<div class="modal-body">
    		<p align="center">	<a class="btn btn-large btn-success" href="excluirClubs?id=${club.id}">Sim, desejo Excluir meu Clube!</a></p>
    		<p></p>
    		<p align="center">	<a class="btn btn-large btn-danger" href="./homePlayer.jsp">Nao, nao sei o que estou fazendo!</a></p>
    	</div>
    	<div class="modal-footer">
    	<button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
    	<!-- <button class="btn btn-primary">Salvar mudanças</button> -->
	</div>
</div>
    
 	<!-- Fim do MODAL -->
	
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div>
          <div class="row-fluid">
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
          <div class="row-fluid">
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->

      <hr>

	<footer>
        <p>&copy; 4Sports - Projeto Futeboleria 2014</p>
	</footer>

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>

  </body>
</html>
