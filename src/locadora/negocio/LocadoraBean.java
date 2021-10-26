package locadora.negocio;

import java.util.List;

import locadora.negocio.excecao.AluguelException;
import locadora.negocio.excecao.FilmeNaoEncontradoException;

public class LocadoraBean {
		
	private Locadora sistema= null;
	private String idFilme= "0";
	
	public LocadoraBean() {  }	

	public void setIdFilme(String idFilme) {
		this.idFilme = idFilme;
	}

	public void setSistema(Locadora sistema) {
		this.sistema = sistema;
	}
	
	public Filme getFilme() throws FilmeNaoEncontradoException {
		return sistema.getFilme(idFilme);
	}
	
	public List<Filme> getFilmes() {
		return sistema.getFilmes();		
	}
	
	public void alugarFilmes(CarrinhoAluguel carrinho) throws AluguelException {
		sistema.alugarFilmes(carrinho);
	}
}
