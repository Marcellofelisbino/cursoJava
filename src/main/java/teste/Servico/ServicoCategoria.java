package teste.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.entidade.Categoria;
import teste.repositorios.RepositorioCategoria;

@Service //Injecao de dependencia
public class ServicoCategoria {

@Autowired
		private RepositorioCategoria repositorio;
		
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS		
		public List<Categoria> findAll() {
			return repositorio.findAll();
		}
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS	
		public Categoria findById(Long id) {			
			Optional<Categoria> wObjeto  = repositorio.findById(id);			
			return wObjeto.get();
		}
}
