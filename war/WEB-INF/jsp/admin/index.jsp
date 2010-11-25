<%@ include file="../../../common/admin/header.jsp"%>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Preço</th>
					<th> </th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td>${produto.nome }</td>
						<td>${produto.descricao }</td>
						<td align="right">${produto.preco}</td>
						<td><a href="<c:url value="/admin/produto/edita?codigo=${produto.codigo}"/>">Editar</a></td>
						<td><a href="<c:url value="/admin/produto/exclui?codigo=${produto.codigo}"/>">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		
	</div>

<%@ include file="../../../common/admin/footer.jsp"%>