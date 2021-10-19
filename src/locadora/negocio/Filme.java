package locadora.negocio;

public class Filme {
	
	private String idFilme;
	private String titulo;
	private String diretores;
	private int ano;
	private double preco;
	private String descricao; 
	
	public Filme () { }
	
	public Filme(String idFilme, String titulo, String diretores, int ano, double preco, String descricao) {
		
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.diretores = diretores;
		this.ano = ano;
		this.preco = preco;
		this.descricao = descricao;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Id: " + idFilme + "\nTítulo: " + titulo + "\nDiretores: " + diretores + "\nAno: " + ano
				+ "\nPreço: " + preco + "\nDescrição: " + descricao;
	}	
}
