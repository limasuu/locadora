package locadora.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import locadora.negocio.excecao.AluguelException;
import locadora.negocio.excecao.FilmeNaoEncontradoException;

public class Locadora {

	List<Filme> estoque;

	public Locadora() {

		this.estoque= new ArrayList<Filme>();		
		popularEstoque();
	}

	private void popularEstoque() {

		Filme filme= new Filme("F00001", "Rio", "Carlos Saldanha", 2011, 4.50, 10, 
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
		estoque.add(filme);

		filme= new Filme("F00002", "Sonic - O Filme", "Jeff Fowler", 2020, 5.99, 5, 
				"Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos"
						+ " para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar"
						+ " o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.");
		estoque.add(filme);

		filme= new Filme("F00003", "Os Incríveis", "Brad Bird", 2004, 4.00, 8, 
				"Roberto Pêra (Craig T. Nelson) já foi o maior herói do planeta, salvando vidas e combatendo o mal"
						+ " todos os dias sob o codinome Sr. Incrível. Porém, após salvar um homem de se suicidar, ele é "
						+ "processado e condenado na Justiça. Uma série de processos seguintes faz com que o Governo tenha"
						+ " que desembolsar uma alta quantia para pagar as indenizações, o que faz com que a opinião pública"
						+ " se volte contra os super-heróis. Em reconhecimento aos serviços prestados, o Governo faz a eles "
						+ "uma oferta: que levem suas vidas como pessoas normais, sem demonstrar que possuem superpoderes, "
						+ "recebendo em troca uma pensão anual. Quinze anos depois, Roberto leva uma vida pacata ao lado de "
						+ "sua esposa Helen (Holly Hunter), que foi a super-heroína Mulher-Elástica, e seus três filhos. "
						+ "Roberto agora trabalha em uma seguradora e luta para combater o tédio da vida de casado e o peso "
						+ "extra. Com vontade de retomar a vida de herói, ele tem a grande chance quando surge um comunicado "
						+ "misterioso, que o convida para uma missão secreta em uma ilha remota.");
		estoque.add(filme);

		filme= new Filme("F00004", "Mulan", " Tony Bancroft, Barry Cook", 1998, 5.50, 5, "Quando os mongóis invadem a "
				+ "China, o imperador (Pat Morita) decreta que cada família ceda um homem para o exército imperial. "
				+ "Com isso, uma jovem fica angustiada ao ver seu velho e doente pai ser convocado, por ser o único "
				+ "homem da família. Ele precisa ir, mesmo sabendo que certamente morrerá, para manter a honra da "
				+ "família. Assim, sua filha rouba sua armadura e espada, se disfarça de homem e se apresenta no "
				+ "lugar do pai, mas os espíritos dos ancestrais decidem protegê-la e ordenam a um dragão (Eddie Murphy),"
				+ " que havia caído em desgraça, que convença a jovem a abandonar seu plano. Ele concorda, mas quando "
				+ "conhece a jovem descobre que ela não pode ter dissuadida e, assim, decide ajudá-la a cumprir sua "
				+ "perigosa missão de ir para a guerra e voltar viva.");
		estoque.add(filme);

		filme= new Filme("F00005", "Frozen 2", "Jennifer Lee, Chris Buck", 2020, 6.99, 8, "Na trama de Frozen 2, de volta à"
				+ " infância de Elsa e Anna, as duas irmãs descobrem uma história do pai, quando ainda era príncipe de "
				+ "Arendelle. Ele conta às meninas a história de uma visita à floresta dos elementos, onde um acontecimento"
				+ " inesperado teria provocado a separação dos habitantes da cidade com os quatro elementos fundamentais:"
				+ " ar, fogo, terra e água. Esta revelação ajudará Elsa a compreender a origem de seus poderes.");
		estoque.add(filme);		
	}

	public List<Filme> getFilmes(){

		return Collections.unmodifiableList(estoque);

	}

	public Filme getFilme(String idFilme) throws FilmeNaoEncontradoException{

		Filme filmeProcurado= null;

		for(Filme f : estoque) {
			if(f.getIdFilme().equals(idFilme))
				filmeProcurado= f;
		}

		if(filmeProcurado == null)
			throw new FilmeNaoEncontradoException("O filme " + idFilme + " não foi encontrado.");

		return filmeProcurado;
	}


	public void alugarFilmes(CarrinhoAluguel carrinho) throws AluguelException{

		Collection<ItemAluguel> itens= carrinho.getItens();
		Iterator<ItemAluguel> i= itens.iterator();

		while(i.hasNext()) {

			ItemAluguel item= (ItemAluguel) i.next();
			alugarFilme(item.getItem().getIdFilme(), item.getQuantidade());
		}
	}

	private void alugarFilme(String idFilme, int quantidade) throws AluguelException {

		Filme filme;

		try {
			filme= getFilme(idFilme);
			
		}catch (FilmeNaoEncontradoException e) {
			throw new AluguelException(e.getMessage());
		}

		int quantidadeEstoque= filme.getQuantidadeEstoque();

		if(quantidadeEstoque - quantidade >= 0) {
			int novaQuantidade= quantidadeEstoque - quantidade;
			filme.setQuantidadeEstoque(novaQuantidade);
			
		}else 
			throw new AluguelException("Filme " + idFilme + " sem estoque suficiente.");
		
	}
}
