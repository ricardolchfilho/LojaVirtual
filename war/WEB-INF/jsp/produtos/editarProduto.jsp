<%@ include file="../../../common/admin/header.jsp"%>

<form id="produtosForm" method="POST" action='<c:url value="/produtos/${produto.codigo}" />'>
	<fieldset>
		<legend>Editar Produto</legend> 
		
		<label for="nome">Nome:</label> 
		<input id="nome" class="requerid" minlength="3" 
			type="text" name="produto.nome" value="${produto.nome}" style="width: 150px"/> 
		
		<label for="descricao">Descrição:</label> 
		<textarea id="descricao" name="produto.descricao" class="requerid" 
			 minlength="1" maxlength="40" style="width: 150px">${produto.descricao}</textarea>
		
		<label for="preco">Preço:</label>
		<input id="preco" type="text" class="requerid" min="0" 
			name="produto.preco" value="${produto.preco}" style="width: 100px"/>
		
		<button type="submit" name="_method" value="PUT">Enviar</button>
		
	</fieldset>
</form>
<script type="text/javascript">
	$("#produtosForm").validate();
</script>
<%@ include file="../../../common/admin/footer.jsp"%>