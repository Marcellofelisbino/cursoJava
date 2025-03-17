package teste.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.entidade.Produto;
import teste.repositorios.RepositorioProduto;

@Service //Injecao de dependencia
public class ServicoProduto {

		@Autowired
		private RepositorioProduto repositorio;
		
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS		
		public List<Produto> findAll() {
			return repositorio.findAll();
		}
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS	
		public Produto findById(Long id) {			
			Optional<Produto> wObjeto  = repositorio.findById(id);			
			return wObjeto.get();
		}
}
