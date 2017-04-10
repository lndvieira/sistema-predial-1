<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Empresa" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Alterar Empresa</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sistema Predial</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Inicio</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<%Empresa empresa = (Empresa)request.getAttribute("empresa"); %>
	
	<p>A empresa foi alterada com sucesso!</p>
	<br>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID:</th>
				<th>Razão Social:</th>
				<th>CNPJ:</th>
				<th>Conjunto:</th>
				<th>Horário de Funcionamento:</th>
				<th>Horário do Ar-Condicionado:</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= empresa.getId() %></td>
				<td><%= empresa.getRazaoSocial() %></td>
				<td><%= empresa.getCnpj() %></td>
				<td><%= empresa.getConjunto() %></td>
				<td><%= empresa.getHoraFuncionamento() %></td>
				<td><%= empresa.getHoraArCondicionado() %></td>
			</tr>
		</tbody>
	</table>
	<br><br>
	
	<a href="predial.html"><button type="button" class="btn btn-warning">Voltar</button></a>
	
	<script src="js/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>