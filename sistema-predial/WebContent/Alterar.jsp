<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Empresa" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Alterar Empresa</title>
</head>
<body>
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
	
	<a href="predial.html"><button type="button">Voltar</button></a>
</body>
</html>