package locadora.teste;

import locadora.negocio.CarrinhoAluguel;
import locadora.negocio.Filme;
import locadora.negocio.Locadora;
import locadora.negocio.excecao.AluguelException;
import locadora.negocio.excecao.CarrinhoException;
import locadora.negocio.excecao.FilmeNaoEncontradoException;

public class Teste {

	public static void main(String[] args) throws FilmeNaoEncontradoException, AluguelException, CarrinhoException {

		Locadora locadora= new Locadora();
		
		System.out.println("-------------- FILMES --------------");
		for(Filme f : locadora.getFilmes())
			System.out.println(f + "\n");
		
		Filme filme1= locadora.getFilme("F00001");
		Filme filme2= locadora.getFilme("F00002");

		CarrinhoAluguel carrinho= new CarrinhoAluguel();

		carrinho.adicionar(filme1);
		carrinho.adicionar(filme2);

		System.out.println("Número de itens: " + carrinho.getNumeroItens());
		System.out.println("Total: R$ " + carrinho.getTotal() + "\n");

		for(Filme filme : carrinho.getItens())
			System.out.println(filme + "\n");

		System.out.println("===========================");

		carrinho.remover(filme1.getIdFilme());

		System.out.println("Número de itens: " + carrinho.getNumeroItens());
		System.out.println("Total: R$ " + carrinho.getTotal() + "\n");

		for(Filme filme : carrinho.getItens())
			System.out.println(filme + "\n");

		System.out.println("===========================");

		locadora.alugarFilmes(carrinho);
		
		System.out.println("-------------- FILMES --------------");
		for(Filme f : locadora.getFilmes())
			System.out.println(f + "\n");
		
	}
}
