<%@ include file="../../../common/admin/header.jsp" %>

<c:if test="${produtos != null}">
	<ul>
		<c:forEach items="${produtos}" var="produto">
			<li>${produto.nome}</li>
		</c:forEach>
		
	</ul>
</c:if>

<%@ include file="../../../common/admin/footer.jsp" %>