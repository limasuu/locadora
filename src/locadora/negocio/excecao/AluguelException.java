package locadora.negocio.excecao;

public class AluguelException extends Exception {

	private static final long serialVersionUID = 1L;

	public AluguelException() {	    }

	public AluguelException(String msg) {
		super(msg);
	}
}
