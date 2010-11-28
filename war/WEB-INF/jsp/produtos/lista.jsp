<%@ include file="../../../common/admin/header.jsp"%>
	
	<c:if test="${acessoRestrito}">
		<div>
			<label style="color: red">Acesso Restrito a Administradores do Sistema!</label>
		</div>
	</c:if>
	
	<c:if test="${!acessoRestrito}">
		<c:if test="${empty produtos}">
		<div>
			<label style="color: red">Nenhum Produto Cadastrado!</label>
		</div>
	</c:if>
	<c:if test="${!empty produtos}">
		<div>
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Descrição</th>
						<th>Preço</th>
						<th>Comprar</th>
						<c:if test="${userService.userAdmin}">
							<th>Editar</th>
							<th>Excluir </th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.nome }</td>
							<td>${produto.descricao }</td>
							<td align="right">${produto.preco}</td>
							<td>
								<form action="<c:url value="/carrinho"/>" method="POST">
									<input type="hidden" name="item.produto.codigo"
										value="${produto.codigo}"/>
									<input class="qtde" name="item.quantidade" value="1"/>
									<button type="submit">Comprar</button>
								</form>
							</td>
							<c:if test="${userService.userAdmin}">
								<td><a href="<c:url value="/produtos/${produto.codigo}"/>">Editar</a></td>
								<td>
									<form action="<c:url value="/produtos/${produto.codigo}"/>" method="POST">
										<button class="link" name="_method" value="DELETE">Excluir</button>
									</form>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	</c:if>

<%@ include file="../../../common/admin/footer.jsp"%>