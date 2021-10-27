<%@ include file="cabecalho.jsp"%>


<h3>Obrigado, ${param.nome}.</h3>

<jsp:useBean id="agora" class="java.util.Date"/>
<jsp:setProperty name="agora" property="time" value="${agora.time+604800000}"/>

<p>A data de devolução dos filmes é <fmt:formatDate value="${agora}" type="date" dateStyle="full"/></p>

<c:remove var="carrinho" scope="session"/>

<c:url var="url" value="/inicio"/>
<p><a href="${url}">Alugar outros filmes</a>



<%@ include file="rodape.jsp"%>