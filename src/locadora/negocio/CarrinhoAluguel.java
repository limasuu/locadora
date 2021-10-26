package locadora.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import locadora.negocio.excecao.CarrinhoException;

public class CarrinhoAluguel {

	private HashMap<String, Filme> itens;

	public CarrinhoAluguel() {

		itens= new HashMap<String, Filme>();
	}

	public synchronized void adicionar(Filme filme) throws CarrinhoException {
		
		if(!itens.containsKey(filme.getIdFilme())) 			
			itens.put(filme.getIdFilme(), filme);		
		else
			throw new CarrinhoException("O filme " + filme.getIdFilme() + " já está no carrinho.");
	}

	public synchronized void remover(String idFilme) {

		if(itens.containsKey(idFilme)) 
			itens.remove(idFilme);		
	}

	public synchronized List<Filme> getItens() {

		List<Filme> lista= new ArrayList<Filme>();
		lista.addAll(itens.values());

		return lista;
	}

	public synchronized int getNumeroItens() {
		
		return itens.size();
	}

	public synchronized double getTotal() {

		double total= 0.0;

		for(Filme filme : itens.values())
			total+= filme.getPreco();

		return total;
	}

	public synchronized void limpar() {

		itens.clear();
	}
}
