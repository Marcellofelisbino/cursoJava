package teste.entidade.ChavePrimariaComposta;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import teste.entidade.OrdemDePedido;
import teste.entidade.Produto;

@Embeddable // anotacao pra chave estrangeira
public class ChaveItemOrdemDePedido implements Serializable{
private static final long serialVersionUID = 1L;

// Referencia Pra Ordem De Pedido
@ManyToOne // relacao muitos pra 1
@JoinColumn(name = "id_ordemPedido")
	private OrdemDePedido ordemDePedido;

// Referencia Pra produto
@ManyToOne // relacao muitos pra 1
@JoinColumn(name = "id_produto")
	private Produto produto;
	
// metodo get e setters	
	public OrdemDePedido getOrdemDePedido() 					{		return ordemDePedido;				}
	public void setOrdemDePedido(OrdemDePedido ordemDePedido) 	{		this.ordemDePedido = ordemDePedido;	}
	public Produto getProduto() 								{		return produto;						}
	public void setProduto(Produto produto) 					{		this.produto = produto;				}
	@Override
	public int hashCode() {
		return Objects.hash(ordemDePedido, produto);
	}
// metodo hashcode and equals	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveItemOrdemDePedido other = (ChaveItemOrdemDePedido) obj;
		return Objects.equals(ordemDePedido, other.ordemDePedido) && Objects.equals(produto, other.produto);
	}
	
}
