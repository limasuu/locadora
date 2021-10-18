package locadora.negocio;

public class Filme {
	
	private String idFilme;
	private String titulo;
	private String diretores;
	private int ano;
	private double preco;
	private int quantidade;
	private String descricao; 
	
	public Filme () { }

	public String getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(String idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretores() {
		return diretores;
	}

	public void setDiretores(String diretores) {
		this.diretores = diretores;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
