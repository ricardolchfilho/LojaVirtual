<%@ include file="../../../common/admin/header.jsp"%>
	<c:if test="${empty carrinho.itens}">
		<div>
			<label style="color: red">Nenhum Produto no Carrinho de Compras!</label>
		</div>
	</c:if>
	<c:if test="${!empty carrinho.itens}">
		<h3>Itens do seu carrinho de compras</h3>
		<table>
			<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Qtde</th>
				<th>Total</th>
				<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
					<tr>
					<td>${item.produto.nome }</td>
					<td>${item.produto.descricao }</td>
					<td><fmt:formatNumber type="currency"
						value="${item.produto.preco }"/>
					</td>
					<td align="right">${item.quantidade }</td>
					<td><fmt:formatNumber type="currency"
						value="${item.quantidade * item.produto.preco }"/>
					</td>
					<td>
						<form action="<c:url value="/carrinho/${s.index }"/>" method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="2"></td>
				<th colspan="1">Total:</th>
				<th align="right">${carrinho.unidades}</th>
				<th><fmt:formatNumber type="currency" value="${carrinho.total}"/></th>
				</tr>
			</tfoot>
		</table>
	</c:if>
<%@ include file="../../../common/admin/footer.jsp"%>