package locadora.negocio.excecao;

public class CarrinhoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CarrinhoException() {	    }

	public CarrinhoException(String msg) {
		super(msg);
	}
}
