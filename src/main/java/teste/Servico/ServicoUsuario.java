package teste.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.entidade.Usuario;
import teste.repositorios.RepositorioUsuario;

@Service //Injecao de dependencia
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
		
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS		
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}
// SERVICO NEGOCIO PRA BUSCAR TODOS OS USUARIOS	
	public Usuario findById(Long id) {			
		Optional<Usuario> wObjeto  = repositorio.findById(id);			
		return wObjeto.get();
	}
//
	public Usuario insere(Usuario wobjeto) {
		return repositorio.save(wobjeto);
	}
}
