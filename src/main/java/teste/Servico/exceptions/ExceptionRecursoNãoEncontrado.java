package teste.Servico.exceptions;
// runtime exception o compilador nao obriga a tratar
public class ExceptionRecursoNãoEncontrado extends RuntimeException{
	private static final long serialVersionUID = 1L;

// Construtor
	public ExceptionRecursoNãoEncontrado (Object id) {
		super("Recurso não encontrado. id =" + id);
	}
}
