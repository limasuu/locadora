<%@ include file="cabecalho.jsp"%>



<p>Valor total do aluguel: <fmt:formatNumber value="${sessionScope.carrinho.total}" type="currency"/></p>

<p>Para efetuar o aluguel, informe os seguintes dados:</p>

<c:url var="url" value="/recibo"/>
<form action="${url}" method="post">
	<table>
		<tr>
			<td>Nome</td>
			<td>
				<input type="text" name="nome"/>
			</td>
		</tr>
		<tr>
			<td>Número do cartão</td>
			<td>
				<input type="text" name="numeroCartao"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Alugar"/>
			</td>
			<td></td>
		</tr>	
	</table>
</form>



<%@ include file="rodape.jsp"%>