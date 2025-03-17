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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable {		
	private static final long serialVersionUID = 1L;

@Id // indica chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY) 	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String urlImagem;
	
// usar Set (conjunto) ao inves de lista, Set é uma interface, nao pode ser instanciado, por isso instanciar utilizando o HashSet, está instanciando para garantir que a categoria nao comece vazia (nula)
@ManyToMany // relacionamento muitos pra muitos
@JoinTable(name = "TB_PRODUTO_CATEGORIA",joinColumns = @JoinColumn (name = "id_produto"),inverseJoinColumns = @JoinColumn (name = "id_categoria"))
	private Set<Categoria> categorias = new HashSet<>();

// precisa ser igual ao que esta na classe chaveItemOrdemDePedido 
@OneToMany(mappedBy = "id.produto")
	private Set<ItemOrdemDePedido> itensOrdemDePedidos = new HashSet<>();

// Construtores	
	public Produto() {
	}
	
	public Produto(Long id, String nome, String descricao, Double preco, String urlImagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.urlImagem = urlImagem;
	}

// metodo get e setters (nao fazer setters de categorias porque sao colecoes e nao queremos altera-las aqui)
	public Long getId() 						{		return id;					}
	public void setId(Long id) 					{		this.id = id;				}
	public String getNome() 					{		return nome;				}
	public void setNome(String nome) 			{		this.nome = nome;			}
	public String getDescricao() 				{		return descricao;			}
	public void setDescricao(String descricao) 	{		this.descricao = descricao;	}
	public Double getPreco() 					{		return preco;				}
	public void setPreco(Double preco) 			{		this.preco = preco;			}
	public String getUrlImagem() 				{		return urlImagem;			}
	public void setUrlImagem(String urlImagem) 	{		this.urlImagem = urlImagem;	}
	public Set<Categoria> getCategorias() 		{		return categorias;			}

@JsonIgnore
	public Set<OrdemDePedido> getOrdemDePedidos(){ 		
		Set<OrdemDePedido> setAux = new HashSet<>();
		for (ItemOrdemDePedido x: itensOrdemDePedidos) {
			setAux.add(x.getOrdemDePedido());
		}
		return setAux;
		
	}
// metodo hashClode() and equals()
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}	
}
