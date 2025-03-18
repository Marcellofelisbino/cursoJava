package teste.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import teste.entidade.Categoria;
import teste.entidade.ItemOrdemDePedido;
import teste.entidade.OrdemDePedido;
import teste.entidade.Pagamento;
import teste.entidade.Produto;
import teste.entidade.Usuario;
import teste.entidade.enums.StatusOrdemDePedido;
import teste.repositorios.RepositorioCategoria;
import teste.repositorios.RepositorioItemOrdemDePedido;
import teste.repositorios.RepositorioOrdemDePedido;
import teste.repositorios.RepositorioProduto;
import teste.repositorios.RepositorioUsuario;

@Configuration // anotacao de confuguracao
@Profile("test")
public class ConfiguracaoTest implements CommandLineRunner{ 
// CommandLIneRunner pra sempre rodar quando a aplicacao iniciar

@Autowired // acoplamento fraco, pelo proprio spring
		private RepositorioUsuario auxUsuario;
@Autowired 
		private RepositorioOrdemDePedido auxOrdemDePedido;	
@Autowired 
		private RepositorioCategoria auxCategoria;
@Autowired 
		private RepositorioProduto auxProduto;		
@Autowired 
		private RepositorioItemOrdemDePedido auxItemOrdemDePedido;		
@Override
		public void run(String... args) throws Exception {

			Categoria c1 = new Categoria(null,"Eletronicos");
			Categoria c2 = new Categoria(null,"Livros");
			Categoria c3 = new Categoria(null,"Computadores");
			Categoria c4 = new Categoria(null,"Celulares");
			Categoria c5 = new Categoria(null,"Games");			
			
			Produto p1 = new Produto(null,"O senhor dos aneis", "A sociedade do anel", 89.90, "");
			Produto p2 = new Produto(null,"O senhor dos aneis 2", "O retorno do rei", 81.10, "");
			Produto p3 = new Produto(null,"O senhor dos aneis 3", "As duas torres ", 79.90, "");
			Produto p4 = new Produto(null,"Smart TV", "televisor com acesso a internet", 1889.90, "");
			Produto p5 = new Produto(null,"Mackbook pro", "notebook", 4500.00, "");
			Produto p6 = new Produto(null,"Pc gamer pichau", "Computador com configuracoes avancadas para games", 2999.90, "");
			Produto p7 = new Produto(null,"Playstation 5 ", "Videogame de ultima geracao", 2889.90, "");
			
			auxCategoria.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
			auxProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
			
			p1.getCategorias().add(c2);
			p2.getCategorias().add(c2);
			p3.getCategorias().add(c2);
			p4.getCategorias().add(c1);
			p5.getCategorias().add(c3);
			p5.getCategorias().add(c1);
			p6.getCategorias().add(c3);
			p6.getCategorias().add(c1);
			p7.getCategorias().add(c5);			
			p7.getCategorias().add(c1);
						
			auxProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
						
			Usuario u1 = new Usuario (null, "Maria Brown", "maria@gmail.com", "95854365", "123456");
			Usuario u2 = new Usuario (null, "Joao de deus", "Joao@gmail.com", "96146516", "456789");
			Usuario u3 = new Usuario (null, "Macunaima de Jesus", "Macu@gmail.com", "97265412", "789456");
			
			OrdemDePedido o1 = new OrdemDePedido(null,Instant.parse("2019-06-20T19:53:07Z"),StatusOrdemDePedido.AGUARDANDO_PAGAMENTO, u1);
			OrdemDePedido o2 = new OrdemDePedido(null,Instant.parse("2019-07-21T19:54:18Z"),StatusOrdemDePedido.CANCELADO ,u2);
			OrdemDePedido o3 = new OrdemDePedido(null,Instant.parse("2019-07-22T15:51:47Z"),StatusOrdemDePedido.ENVIADO,u1);	
			OrdemDePedido o4 = new OrdemDePedido(null,Instant.parse("2019-07-25T14:52:55Z"),StatusOrdemDePedido.PAGO,u1);
			
			ItemOrdemDePedido iop1 = new ItemOrdemDePedido(o1, p1, 2, p1.getPreco());
	    	ItemOrdemDePedido iop2 = new ItemOrdemDePedido(o1, p3, 1, p3.getPreco());
			ItemOrdemDePedido iop3 = new ItemOrdemDePedido(o2, p3, 2, p3.getPreco());
			ItemOrdemDePedido iop4 = new ItemOrdemDePedido(o3, p5, 3, p5.getPreco());
			ItemOrdemDePedido iop5 = new ItemOrdemDePedido(o4, p7, 8, p7.getPreco());
			
			auxUsuario.saveAll(Arrays.asList(u1, u2, u3));
			auxOrdemDePedido.saveAll(Arrays.asList(o1, o2, o3, o4));					
			
			auxItemOrdemDePedido.saveAll(Arrays.asList(iop1, iop2, iop3, iop4, iop5));
			
			Pagamento pag1 =  new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"), o1);
			o1.setPagamento(pag1); // associou "o1" com "pag1"
			auxOrdemDePedido.saveAll(Arrays.asList(o1)); //nao atualizou a ordem de pedido, porem serve pra atualizar o pagamento com o status
		}
}
