<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>BEM VINDO AO FUTEBOLERIA</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<!-- Modal -->

<link href="js/bootstrap-modal.js">
<link href="js/bootstrap.js">
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

    <div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">Sobre</a></li>
          <li><a href="#">Contato</a></li>
          <li><a href="#loginModalAccess" role="button" data-toggle="modal">Ja sou cadastrado</a></li>
        </ul>
        <h3 class="muted">Projeto Futeboleria</h3>
      </div>

      <hr>

	<!-- Button to trigger modal --> 
<div class="jumbotron">

        <h1>Uma super carreira te aguarda!</h1>
        <p class="lead">Crie agora mesmo seu usuario e mostre ao mundo seu talento. Faca upload de suas jogadas com videos, fotos e muitos mais que já realizou no esporte. Conte sua historia nos queremos te conhecer</p>
        <a href="#loginModal" role="button" class="btn btn-large btn-success" data-toggle="modal">Cadastrar Hoje</a>
      </div>
     
    <!-- Modal -->
    <div id="loginModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3 id="myModalLabel">Quem você é ?</h3>
    	</div>
    	<div class="modal-body">
    		<p align="center">	<a class="btn btn-large btn-info" href="./cadastroPlayer.jsp">Cadastrar Atleta</a>
    							<a class="btn btn-large btn-primary" href="./cadastroClub.jsp">Cadastrar Clube</a></p>
    	</div>
    	<div class="modal-footer">
    		<button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
    		<!-- <button class="btn btn-primary">Salvar mudanças</button> -->
    	</div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<script type="text/javascript">
    $(window).load(function(){
        $('#myModal').modal('show');
    });
</script>
    
    <script src="js/bootstrap.js"></script>

<div id="loginModalAccess" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3 id="myModalLabel">Quem você é ?</h3>
    	</div>
    	<div class="modal-body">
    		<p align="center">	<a class="btn btn-large btn-info" href="./Login.jsp">Login como Atleta</a>
    							<a class="btn btn-large btn-primary" href="./LoginClub.jsp">Login como Clube</a></p>
    	</div>
    	<div class="modal-footer">
    		<button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
    		<!-- <button class="btn btn-primary">Salvar mudanças</button> -->
    	</div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<script type="text/javascript">
    $(window).load(function(){
        $('#myModal').modal('show');
    });
</script>
    
    <script src="js/bootstrap.js"></script>

 <!-- <div class="jumbotron">
        <h1>Uma super carreira te aguarda!</h1>
        <p class="lead">Crie agora mesmo seu usuario e mostre ao mundo seu talento. Faca upload de suas jogadas com videos, fotos e muitos mais que já realizou no esporte. Conte sua historia nos queremos te conhecer</p>
        <a class="btn btn-large btn-success" href="./cadastroPlayer.jsp">Cadastrar Hoje</a>
      </div>
 -->
      <hr>

      <div class="row-fluid marketing">
        <div class="span6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="span6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

          <h4>Subheading</h4>
          <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

          <h4>Subheading</h4>
          <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
      </div>

      <hr>

      <div class="footer">
        <p>&copy; Company 2012</p>
      </div>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js" type="text/javascript"></script>
    
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
