<%@ include file="../../../common/admin/header.jsp"%>

<form method="post" action='<c:url value="/admin/produto/edita" />'>
	<fieldset>
		<legend>Editar Produto</legend> 
		<input id="codigo" type="hidden" name="produto.codigo" value="${produto.codigo}">
		
		<label for="nome">Nome:</label> 
		<input id="nome" type="text" name="produto.nome" value="${produto.nome}" style="width: 150px"/> 
		
		<label for="descricao">Descrição:</label> 
		<textarea id="descricao" name="produto.descricao" style="width: 150px">${produto.descricao}</textarea>
		
		<label for="preco">Preço:</label>
		<input id="preco" type="text" name="produto.preco" value="${produto.preco}" style="width: 100px"/>
		
		<button type="submit">Enviar</button>
		
	</fieldset>
</form>

<%@ include file="../../../common/admin/footer.jsp"%>