
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
    <meta charset="utf-8">
    <title>CADASTRO DE CLUBE AO FUTEBOLERIA</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-cadastro {
        max-width: 600px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-cadastro .form-cadastro-heading,
      .form-cadastro .checkbox {
        margin-bottom: 10px;
      }
      .form-cadastro input[type="text"],
      .form-cadastro input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
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

    <div class="container">

      <form class="form-cadastro " action="salvarCadastroClub?id=${club.id}" method="post">
        <h2 class="form-cadastro-heading">Dados Cadastrais Para Clube</h2>
        <input type="text" name="txtUsername" class="input-block-level" placeholder="Nome de Login">
        <input type="password" name="txtPassword" class="input-block-level" placeholder="Password">
        <input type="text" name="txtNome" class="input-block-level"  placeholder="Nome">
        <input type="text" name="txtEmail" class="input-block-level"  placeholder="Email address">
        <input type="text" name="txtEndereco" class="input-block-level" placeholder="Endereço">
        <input type="text" name="txtBairro" class="input-block-level"  placeholder="Bairro">
        <input type="text" name="txtCidade" class="input-block-level"  placeholder="Cidade">
        <input type="text" name="txtTelefone" class="input-block-level"  placeholder="Telefone">
        <input type="text" name="txtCpf" class="input-block-level" placeholder="CPF">
        
        <button class="btn btn-large btn-primary" value="salvar" name="btnSalvar" type="submit">Salvar</button>
        <button class="btn btn-large btn-warning" value="reset" name="btnReset" type="reset">Limpar</button>
        <a class="btn btn-large pull-right" href="./bemvindo.jsp">Voltar</a>
      </form>

	<footer>
        <p>&copy; 4Sports - Projeto Futeboleria 2014</p>
	</footer>

    </div> <!-- /container -->

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
