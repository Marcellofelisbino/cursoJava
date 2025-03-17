package teste.entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_CATEGORIA")
public class Categoria implements Serializable {		
	private static final long serialVersionUID = 1L;

@Id // indica chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

@JsonIgnore // uma colecao chamando a outra (categoria e produto) da ruim no postman (looping), esse comando corrige
@ManyToMany (mappedBy = "categorias") // relacionamento muitos pra muitos, referenciando o join feito na classe produto 
	private Set<Produto> produto = new HashSet<>(); 
	
// construtor 	
	public Categoria() {		
	}
	public Categoria(Long id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
}
// get e setters
	public Long getId()              {		return id;					}
	public void setId(Long id)       {		this.id = id;				}
	public String getNome()          {		return nome;				}
	public void setNome(String nome) {		this.nome = nome;			}
	public Set<Produto> getProduto() {		return produto;         	}

// hashCode equals
	@Override
	public int hashCode() 			 {		return Objects.hash(id);	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
}
