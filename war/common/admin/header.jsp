<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="pt-BR">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Loja Virtual</title>
	<meta name="author" content="Ricardo Luiz">
	<link type="text/css" rel="stylesheet" media="screen, projection" href='<c:url value="/stylesheets/geral.css" />' />
	<link type="text/css" rel="stylesheet" media="screen, projection" href='<c:url value="/stylesheets/jquery-ui-1.8.6.custom.css" />' />
	<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/javascripts/jquery.autocomplete.css"/>" />
	<script type="text/javascript" src="<c:url value="/javascripts/jquery-1.3.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascripts/jquery.validate.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascripts/jquery.autocomplete.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascripts/jquery.puts.js"/>"></script>
</head>

<body>
	<div id="header">
		
		<h1>Administração</h1>
		
		<div style="float: right">
			<div class="navegacao">
				<nav>
					<a href='<c:url value="${logoutUrl}" />'>logout ${user.nickname}</a>
				</nav>
			</div>
		</div>
		
	</div>
	<div id="erros">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category} - ${error.message}</li>
			</c:forEach>
		</ul>
	</div>
	<div id="body">
		<div id="menu">
			<ul>
				<li><a href="<c:url value="/produtos/novo"/>">Novo Produto</a></li>
				<li><a href="<c:url value="/produtos"/>">Lista Produtos</a></li>
				<li>
					<form action="<c:url value="/produtos/busca"/>">
						<input id="busca" name="nome"/>
					</form>
					<script type="text/javascript">
						$("#busca").puts("Busca produtos por nome");
						$("#busca").autocomplete("<c:url value="/produtos/busca.json"/>", {
								dataType: "json", 
								parse: function(produtos) { 
									return $.map(produtos, function(produto) {
										return {
											data: produto, 
											value: produto.nome, 
											result: produto.nome 
										};
									});
								},
							formatItem: function(produto) {
								return produto.nome + "(" + produto.preco + ")";
							}
						});
					</script>
				</li>
			</ul>
		</div>
		<div id="content">
		
			<c:if test="${aviso != null}">
				<div class="ui-widget" id="fade-box">
					<div class="ui-state-highlight ui-corner-all"> 
						<p><span style="float: left; margin-right: 0.3em;" class="ui-icon ui-icon-info"></span>
						${aviso}
					</div>
				</div>
			</c:if>