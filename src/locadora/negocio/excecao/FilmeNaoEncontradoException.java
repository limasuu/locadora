package locadora.negocio.excecao;

public class FilmeNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {	    }

	public FilmeNaoEncontradoException(String msg) {
		super(msg);
	}
}
