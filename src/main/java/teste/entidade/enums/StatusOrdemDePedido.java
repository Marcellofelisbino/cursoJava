package teste.entidade.enums;

public enum StatusOrdemDePedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	RECEBIDO(4),
	CANCELADO(5);

	private int codigo;
	
	public Integer getCodigo() {	
		return codigo;
	}	
	private StatusOrdemDePedido(int codigo) {
		this.codigo = codigo;
	}	
	
	public static StatusOrdemDePedido valueof(int codigo) {
		for (StatusOrdemDePedido valor : StatusOrdemDePedido.values()) {
			if (valor.getCodigo() == codigo)
				return valor;
		}
		throw new IllegalArgumentException("Status da ordem de pedido invalido");
	}		
}
