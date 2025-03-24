package teste.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.Servico.exceptions.ExceptionRecursoNãoEncontrado;
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
// SERVICO NEGOCIO PRA BUSCAR USUARIO	
	public Usuario findById(Long id) {			
		Optional<Usuario> wObjeto  = repositorio.findById(id);			
		return wObjeto.orElseThrow(() -> new ExceptionRecursoNãoEncontrado(id));
	}
// SERVICO NEGOCIO PRA inserir usuario
	public Usuario insere(Usuario wObjeto) {
		return repositorio.save(wObjeto);
	}
// SERVICO NEGOCIO PRA deletar usuario	
	public void deleta(Long id) {
		repositorio.deleteById(id);		
	}
// SERVICO NEGOCIO PRA atualizar usuario
	public Usuario  atualiza(Long id,Usuario wObjeto) {
		Usuario entidade = repositorio.getReferenceById(id); // ainda nao vai no banco de dados, so deixa objeto monitorado, diferente do findById, nesse caso é mais performatico fazer isso
		atualizaDados(entidade, wObjeto); // chama metodo 
		return repositorio.save(entidade);		
	}
// metodo pra atualizar variavel entidade
	public void atualizaDados(Usuario entidade, Usuario wObjeto) {
		entidade.setNome(wObjeto.getNome());
		entidade.setEmail(wObjeto.getEmail());
		entidade.setTelefone(wObjeto.getTelefone());		
	}
}
