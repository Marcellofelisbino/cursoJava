package teste.entidade;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import teste.entidade.ChavePrimariaComposta.ChaveItemOrdemDePedido;
@Entity
@Table(name = "TB_Item_ordempedido")
public class ItemOrdemDePedido implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId // por se tratar de chave composta nao usar o @Id
	private ChaveItemOrdemDePedido id = new ChaveItemOrdemDePedido();	
	private Integer quantidade;	
	private Double preco;
	
// metodo construtor	
	public ItemOrdemDePedido() {		
	}
	public ItemOrdemDePedido(OrdemDePedido ordemDePedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setOrdemDePedido(ordemDePedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}	
	
// metodo get e setters
	@JsonIgnore
	public OrdemDePedido getOrdemDePedido() 					{	return id.getOrdemDePedido();		}
	public void setOrdemDePedido(OrdemDePedido ordemDePedido) 	{ 	id.setOrdemDePedido(ordemDePedido); }	
	
	public Produto getProduto() 								{	return id.getProduto();				}
	public void setProduto	(Produto produto) 					{ 	id.setProduto(produto);   			}
	
	public Integer getQuantidade() 								{		return quantidade;				}
	public void setQuantidade(Integer quantidade) 				{		this.quantidade = quantidade;	}
	public Double getPreco() 									{		return preco;					}
	public void setPreco(Double preco) 							{		this.preco = preco;				}

	
//hash code and equals
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ItemOrdemDePedido other = (ItemOrdemDePedido) obj;
		if (id==null){
			if (other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;		
	}	
}
