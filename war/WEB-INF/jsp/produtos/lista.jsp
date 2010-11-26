R<%@ include file="../../../common/admin/header.jsp"%>
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
							<td><a href="<c:url value="/produtos/${produto.codigo}"/>">Editar</a></td>
							<td>
								<form action="<c:url value="/produtos/${produto.codigo}"/>" method="POST">
									<button class="link" name="_method" value="DELETE">Excluir</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	

<%@ include file="../../../common/admin/footer.jsp"%>