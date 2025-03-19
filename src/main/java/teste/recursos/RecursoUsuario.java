package teste.recursos;
//CONTROLADOR REST

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste.Servico.ServicoUsuario;
import teste.entidade.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoAux;

@GetMapping // get (leitura)  vai receber a classe usuario (consulta)
	public ResponseEntity<List<Usuario>> findAll(){ // pesquisa todos
		List<Usuario> listServicoEncontrado = servicoAux.findAll(); 
		return ResponseEntity.ok().body(listServicoEncontrado); 
	}
@GetMapping(value = "/{id}") // esse comando indica que vou aceitar um ID na requisicao da minha URL
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario wObjeto = servicoAux.findById(id);
		return ResponseEntity.ok().body(wObjeto);
	}
@PostMapping // comando pra gravar na tabela
	public ResponseEntity<Usuario> insere(@RequestBody Usuario wObjeto) { //@RquestBody transforma json recebido em formato tabela
		wObjeto =  servicoAux.insere(wObjeto);
// buscar uri pra retornar, pra insercao, nao deve retornar 200, mas sim 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(wObjeto.getId()).toUri();
		return ResponseEntity.created(uri).body(wObjeto);
	}
@DeleteMapping(value = "/{id}")  // comando pra deletar da tabela
//VOID porque nao vai retornar nada
	public ResponseEntity<Void> deleta(@PathVariable Long id){ //@PathVariable serve para reconhecer que o Id vai vir da URL
		servicoAux.deleta(id);
		return ResponseEntity.noContent().build();	//noContent é resposta vazia e ja trata o codigo retorno 204
	}
}