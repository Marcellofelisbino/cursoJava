package teste.entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import teste.entidade.enums.StatusOrdemDePedido;

@Entity // injecao de depencencia nesessario para as entidades
@Table(name="TB_OrdemDePedido")


public class OrdemDePedido implements Serializable {		
	private static final long serialVersionUID = 1L;
	
@Id // indica chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHoraPedido;		
	
	private Integer statusOrdemDePedido;
	
@ManyToOne //Para criacao de chave estrangeira na tabela, relacionamento muitos pra um
@JoinColumn(name = "Cliente_id") // nome da chave estranjeira
	private Usuario cliente;	
	
@OneToMany(mappedBy = "id.ordemDePedido")
	private Set<ItemOrdemDePedido> itens = new HashSet<>();
	
@OneToOne(mappedBy= "OrdemDePedido" , cascade = CascadeType.ALL) //comando cascade para  o pagamento ter a mesma chave do ordemDePedido
private Pagamento pagamento;
	
//construtor
	public OrdemDePedido() {			
	}
	public OrdemDePedido(Long id, Instant dataHoraPedido, StatusOrdemDePedido statusOrdemDePedido, Usuario cliente) {
		super();
		this.id = id;
		this.dataHoraPedido = dataHoraPedido;
		setStatusOrdemDePedido(statusOrdemDePedido);
		this.cliente = cliente;
	}
	
// get e seters	
	public Long getId() 									{	return id;												}
	public void setId(Long id) 								{	this.id = id;											}
	public Instant getDataHoraPedido() 						{	return dataHoraPedido;									}
	public void setDataHoraPedido(Instant dataHoraPedido)	{	this.dataHoraPedido = dataHoraPedido;					}
	public StatusOrdemDePedido getStatusOrdemDePedido() 	{	return StatusOrdemDePedido.valueof(statusOrdemDePedido);}
	public Usuario getCliente() 							{	return cliente;											}
	public void setCliente(Usuario cliente) 				{	this.cliente = cliente;									}
	public void setStatusOrdemDePedido(StatusOrdemDePedido statusOrdemDePedido)	{
		if (statusOrdemDePedido != null)
			this.statusOrdemDePedido = statusOrdemDePedido.getCodigo();
	}	
	public Set<ItemOrdemDePedido> getItens() 				{	return itens;								}			
	public Pagamento getPagamento() 						{	return pagamento;							}
	public void setPagamento(Pagamento pagamento) 			{	this.pagamento = pagamento; 				}
	
@Override
	public int hashCode() {
		return Objects.hash(id);
	}
@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemDePedido other = (OrdemDePedido) obj;
		return Objects.equals(id, other.id);
	}
}	

