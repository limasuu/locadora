<%@ include file="cabecalho.jsp"%>



<jsp:useBean id="locadoraBean" class="locadora.negocio.LocadoraBean" scope="page">
	<jsp:setProperty name="locadoraBean" property="sistema" value="${sistema}"/>
</jsp:useBean>


<c:if test="${param.limpar == 'limpar' }">
	<p class="aviso">O carrinho foi esvaziado!</p>
</c:if>

<c:if test="${param.remover != '0'}">
	<c:set var="id" value="${param.remover}"/>
	<jsp:setProperty name="locadoraBean" property="idFilme" value="${id}"/>
	<c:set var="filmeRemovido" value="${locadoraBean.filme}"/>
	
	<p class="aviso">"${filmeRemovido.titulo}" removido do carrinho.</p>
</c:if>


<c:if test="${sessionScope.carrinho.numeroItens <= 0}">	
	<c:url var="url" value="/catalogo">
		<c:param name="Add" value=""/>
	</c:url>
	<p><a href="${url}">Ver catálogo</a></p>
</c:if>

<c:if test="${sessionScope.carrinho.numeroItens > 0}">

	<p>
		Quantidade de itens no carrinho: ${sessionScope.carrinho.numeroItens}
	
		<c:if test="${sessionScope.carrinho.numeroItens == 1}">
		 filme.
		</c:if>
		<c:if test="${sessionScope.carrinho.numeroItens > 1}">
		 filmes.
		</c:if>
	</p>
	
	
	<table>
		<tr>
			<th>Título</th>
			<th>Preço</th>
		</tr>
		
		<c:forEach var="filme" items="${sessionScope.carrinho.itens}">
			<tr>
				<td class="nome-filme destaque-filme">
					<c:url var="url" value="/detalhesFilme">
						<c:param name="idFilme" value="${filme.idFilme}"/>
					</c:url>
					<a href="${url}">${filme.titulo}</a>
				</td>
		
				<td class="preco-filme destaque-filme">
					<fmt:formatNumber value="${filme.preco}" type="currency"/>
				</td>
				
				<td class="remover-filme destaque-filme">
					<c:url var="url" value="/mostrarCarrinho">
						<c:param name="remover" value="${filme.idFilme}"/>
					</c:url>
					<a href="${url}">Remover</a>
				</td>	
			</tr>		
		</c:forEach>
		
		<tr>
			<td colspan="3"></td>
		</tr>
		
		<tr>
			<td colspan="2">Subtotal</td>
			<td class="preco-filme destaque-filme">
				<fmt:formatNumber value="${sessionScope.carrinho.total}" type="currency"/>
			</td>
		</tr>
	</table>
	
	<p>
		<c:url var="url" value="/catalogo">
			<c:param name="Add" value=""/>
		</c:url>
		<a href="${url}">Ver catálogo</a>
		
		<c:url var="url" value="/alugar"/>
		<a href="${url}">Finalizar aluguel</a>
		
		<c:url var="url" value="/mostrarCarrinho">
			<c:param name="limpar" value="limpar"/>
			<c:param name="remover" value="0"/>
		</c:url>
		<a href="${url}">Esvaziar carrinho</a>
	
	</p>

</c:if>



<%@ include file="rodape.jsp"%>
