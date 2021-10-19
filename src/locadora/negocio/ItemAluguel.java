package locadora.negocio;

public class ItemAluguel {
	
	private Filme item;
	private int quantidade;
	
	public ItemAluguel(Filme item) {
		
		this.item= item;
		quantidade= 1;
	}

	public Filme getItem() {
		return item;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void incrementaQuantidade() {
		quantidade++;
	}
	
	public void decrementaQuantidade() {
		quantidade--;
	}

	@Override
	public String toString() {
		return item + "\nQuantidade do item: " + quantidade;
	}
	
	
}
