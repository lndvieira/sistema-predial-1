<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Empresa" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Excluir Empresa</title>
</head>
<body>
	<%Empresa empresa = (Empresa)request.getAttribute("empresa"); %>
	
	<p>A empresa foi removida com sucesso! <strong> ID: <%= empresa.getId() %></strong></p>
	<br><br>
	
	<a href="predial.html"><button type="button">Voltar</button></a>
</body>
</html>