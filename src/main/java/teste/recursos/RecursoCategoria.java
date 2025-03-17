package teste.recursos;
//CONTROLADOR REST

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.Servico.ServicoCategoria;
import teste.entidade.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {
	
	@Autowired
	private ServicoCategoria servicoAux;

//responseEntity vai receber a classe categoria
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> listServicoEncontrado = servicoAux.findAll(); 
		return ResponseEntity.ok().body(listServicoEncontrado); 
	}
	@GetMapping(value = "/{id}") // esse comando indica que vou aceitar um ID na requisicao da minha URL
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria wObjeto = servicoAux.findById(id);
		return ResponseEntity.ok().body(wObjeto);
	}
}