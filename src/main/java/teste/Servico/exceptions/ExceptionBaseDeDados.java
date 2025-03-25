package teste.Servico.exceptions;

public class ExceptionBaseDeDados  extends RuntimeException{
	private static final long serialVersionUID = 1L;
// Construtor
	public ExceptionBaseDeDados (String msg) {
		super(msg);
	}
}
