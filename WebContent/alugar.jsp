<%@ include file="cabecalho.jsp"%>



<p>Valor total do aluguel: <fmt:formatNumber value="${sessionScope.carrinho.total}" type="currency"/></p>

<p>Para efetuar o aluguel, informe os seguintes dados:</p>

<c:url var="url" value="/recibo"/>
<form action="${url}" method="post" id="formulario">
	<table>
		<tr>
			<td>Nome</td>
			<td>
				<input type="text" name="nome" id="nome"/>
			</td>
			<td>Endereço</td>
			<td>
				<input type="text" name="endereco" id="endereco"/>
			</td>
		</tr>
		<tr>
			<td>Número do cartão</td>
			<td>
				<input type="text" name="numeroCartao" id="numeroCartao" value="xxxx.xxxx.xxxx.xxxx" onFocus="limparCartao()"/>
			</td>
			<td>Bandeira</td>
			<td>
				<input type="text" name="bandeira" id="bandeira"/>
			</td>
		</tr>
		<tr>
			<td>Validade</td>
			<td>
				<input type="text" name="validade" id="validade"/>
			</td>
			<td>Código de segurança</td>
			<td>
				<input type="text" name="cvc" id="cvc"/>
			</td>
		</tr>
		<tr>
			<td>Nome no cartão</td>
			<td>
				<input type="text" name="nomeCartao" id="nomeCartao"/>
			</td>
			<td>CPF</td>
			<td>
				<input type="text" name="cpf" id="cpf"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" onClick="alugar()" value="Alugar"/>
			</td>
			<td></td>
		</tr>	
	</table>
</form>



<%@ include file="rodape.jsp"%>