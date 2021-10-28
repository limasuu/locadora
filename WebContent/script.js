function alugar(){
	
	var formulario= document.getElementById("formulario");
	var nome= document.getElementById("nome");
	var endereco= document.getElementById("endereco");	
	var numeroCartao= document.getElementById("numeroCartao");
	var bandeira= document.getElementById("bandeira");
	var validade= document.getElementById("validade");
	var cvc= document.getElementById("cvc");
	var nomeCartao= document.getElementById("nomeCartao");
	var cpf= document.getElementById("cpf");
	
	if(nome.value == null || nome.value == ""){
		alert("Digite seu nome!");
		return false;
		
	}else if(endereco.value == null || endereco.value == ""){
		alert("Digite seu endereco!");
		return false;
		
	}else if(numeroCartao.value == null || numeroCartao.value == "" || numeroCartao.value == "xxxx.xxxx.xxxx.xxxx"){
		alert("Digite o numero do cartao!");
		return false;
		
	}else if(bandeira.value == null || bandeira.value == ""){
		alert("Digite a bandeira do cartao!");
		return false;
		
	}else if(validade.value == null || validade.value == ""){
		alert("Digite a validade do cartao!");
		return false;
		
	}else if(cvc.value == null || cvc.value == ""){
		alert("Digite o codigo de seguranca do cartao!");
		return false;
		
	}else if(nomeCartao.value == null || nomeCartao.value == ""){
		alert("Digite o nome que aparece no cartao!");
		return false;
		
	}else if(cpf.value == null || cpf.value == ""){
		alert("Digite seu CPF!");
		return false;
		
	}else{
		formulario.submit();		
	}	
	return true;
}

function limparCartao(){
	
	var numeroCartao= document.getElementById("numeroCartao");
	
	if(numeroCartao.value == "xxxx.xxxx.xxxx.xxxx")
		numeroCartao.value= "";	
}