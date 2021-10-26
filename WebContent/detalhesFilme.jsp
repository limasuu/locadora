<%@include file="/cabecalho.jsp"%>



<jsp:useBean id="locadoraBean" class="locadora.negocio.LocadoraBean" scope="page">
	<jsp:setProperty name="locadoraBean" property="sistema" value="${sistema}"/>
</jsp:useBean>

<c:if test="${!empty param.idFilme}">
	<c:set var="id" value="${param.idFilme}"/>

	<jsp:setProperty name="locadoraBean" property="idFilme" value="${id}"/>
	<c:set var="filme" value="${locadoraBean.filme}"/>
	
	<h2>${filme.titulo}</h2>
	<p>Direção de ${filme.diretores} (${filme.ano})</p>
	
	<h4>Descrição:</h4>
	<p>${filme.descricao}</p>
	
	<h4>Preço:</h4>
	<p><fmt:formatNumber value="${filme.preco}" type="currency"/></p>
	
	<c:url var="url" value="/catalogo">
		<c:param name="Add" value="${id}"/>
	</c:url>
	<a href="${url}">Adicionar ao carrinho</a>
</c:if>
	
<c:url var="url" value="/catalogo">
	<c:param name="Add" value=""/>
</c:url>
<a href="${url}">Continuar alugando</a>
	
	

<%@include file="/rodape.jsp"%>