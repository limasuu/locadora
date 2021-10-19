package locadora.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarrinhoAluguel {

	private HashMap<String, ItemAluguel> itens;

	public CarrinhoAluguel() {

		itens= new HashMap<String, ItemAluguel>();
	}

	public synchronized void adicionar(Filme filme) {

		if(itens.containsKey(filme.getIdFilme())) {
			ItemAluguel item= itens.get(filme.getIdFilme());
			item.incrementaQuantidade();
		}else {
			ItemAluguel item= new ItemAluguel(filme);
			itens.put(filme.getIdFilme(), item);
		}
	}

	public synchronized void remover(String idFilme) {

		if(itens.containsKey(idFilme)) {
			ItemAluguel item= itens.get(idFilme);
			item.decrementaQuantidade();

			if(item.getQuantidade() == 0)
				itens.remove(idFilme);
		}
	}

	public synchronized List<ItemAluguel> getItens() {

		List<ItemAluguel> lista= new ArrayList<ItemAluguel>();
		lista.addAll(itens.values());

		return lista;
	}

	public synchronized int getNumeroItens() {

		int numero= 0;

		for(ItemAluguel item : itens.values())
			numero+= item.getQuantidade();

		return numero;
	}

	public synchronized double getTotal() {

		double total= 0.0;

		for(ItemAluguel item : itens.values())
			total+= item.getQuantidade() * item.getItem().getPreco();

		return total;
	}

	public synchronized void limpar() {

		itens.clear();
	}

}
