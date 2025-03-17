package teste.recursos;
//CONTROLADOR REST

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.Servico.ServicoUsuario;
import teste.entidade.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoAux;

//responseEntity vai receber a classe usuario
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> listServicoEncontrado = servicoAux.findAll(); 
		return ResponseEntity.ok().body(listServicoEncontrado); 
	}
	@GetMapping(value = "/{id}") // esse comando indica que vou aceitar um ID na requisicao da minha URL
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario wObjeto = servicoAux.findById(id);
		return ResponseEntity.ok().body(wObjeto);
	}
}