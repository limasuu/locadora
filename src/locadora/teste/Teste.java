package locadora.teste;

import locadora.negocio.CarrinhoAluguel;
import locadora.negocio.Filme;
import locadora.negocio.ItemAluguel;

public class Teste {

	public static void main(String[] args) {


		Filme filme1= new Filme("F00001", "Rio", "Carlos Saldanha", 2011, 4.50, 
				"Blu (Jesse Eisenberg) é uma arara azul que nasceu no Rio de Janeiro mas, "
						+ "capturada na floresta, foi parar na fria Minnesota, nos Estados Unidos. "
						+ "Lá é criada por Linda (Leslie Mann), com quem tem um forte laço afetivo. "
						+ "Um dia, Túlio (Rodrigo Santoro) entra na vida de ambos. Ornitólogo, ele "
						+ "diz que Blu é o último macho da espécie e deseja que ele acasale com a "
						+ "única fêmea viva, que está no Rio de Janeiro. Linda e Blu partem para a "
						+ "cidade maravilhosa, onde conhecem Jade (Anne Hathaway). Só que ela é um "
						+ "espírito livre e detesta ficar engaiolada, batendo de frente com Blu logo"
						+ " que o conhece. Quando o casal é capturado por uma quadrilha de venda de "
						+ "aves raras, eles ficam presos por uma corrente na pata. É quando precisam"
						+ " unir forças para escapar do cativeiro.");

		Filme filme2= new Filme("F00002", "Sonic - O Filme", "Jeff Fowler", 2020, 5.99,
				"Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos"
						+ " para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar"
						+ " o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.");

		CarrinhoAluguel carrinho= new CarrinhoAluguel();

		carrinho.adicionar(filme1);
		carrinho.adicionar(filme1);
		carrinho.adicionar(filme2);

		System.out.println("Número de itens: " + carrinho.getNumeroItens());
		System.out.println("Total: R$ " + carrinho.getTotal() + "\n");

		for(ItemAluguel item : carrinho.getItens())
			System.out.println(item + "\n");
		
		System.out.println("===========================");

		carrinho.remover(filme2.getIdFilme());

		System.out.println("Número de itens: " + carrinho.getNumeroItens());
		System.out.println("Total: R$ " + carrinho.getTotal() + "\n");

		for(ItemAluguel item : carrinho.getItens())
			System.out.println(item + "\n");
		
		System.out.println("===========================");

		carrinho.limpar();

		System.out.println("Número de itens: " + carrinho.getNumeroItens());
		System.out.println("Total: R$ " + carrinho.getTotal() + "\n");

		for(ItemAluguel item : carrinho.getItens())
			System.out.println(item + "\n");

	}
}
