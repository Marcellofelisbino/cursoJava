package teste.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.entidade.OrdemDePedido;
import teste.repositorios.RepositorioOrdemDePedido;

@Service //Injecao de dependencia
public class ServicoOrdemDePedido {

		@Autowired
		private RepositorioOrdemDePedido repositorio;
		
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS		
		public List<OrdemDePedido> findAll() {
			return repositorio.findAll();
		}
// SERVICO NEGOCIO PRA BUSCAR TODOS AS ORDENS DE  USUARIOS	
		public OrdemDePedido findById(Long id) {			
			Optional<OrdemDePedido> wObjeto  = repositorio.findById(id);			
			return wObjeto.get();
		}
}
