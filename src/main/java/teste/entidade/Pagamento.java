package teste.entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // injecao de depencencia nesessario para as entidades
@Table(name="TB_pagamento")
public class Pagamento implements Serializable{	
	private static final long serialVersionUID = 1L;

@Id // indica chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;	

@OneToOne
@MapsId
	private OrdemDePedido OrdemDePedido;

// construtores	
	public Pagamento() {		
	}

	public Pagamento(Long id, Instant momento, teste.entidade.OrdemDePedido ordemDePedido) {
		super();
		this.id = id;
		this.momento = momento;
		OrdemDePedido = ordemDePedido;
	}
// get e seters
	public Long getId() 										{	return id;	}
	public void setId(Long id) 									{	this.id = id;	}
	public Instant getMomento() 								{	return momento;	}
	public void setMomento(Instant momento) 					{	this.momento = momento;	}
	public OrdemDePedido getOrdemDePedido() 					{	return OrdemDePedido;	}
	public void setOrdemDePedido(OrdemDePedido ordemDePedido) 	{	OrdemDePedido = ordemDePedido;	}

//hashCode and equals	
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
}
