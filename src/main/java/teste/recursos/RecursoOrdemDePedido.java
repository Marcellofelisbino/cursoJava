package teste.recursos;
//CONTROLADOR REST

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.Servico.ServicoOrdemDePedido;
import teste.entidade.OrdemDePedido;

@RestController
@RequestMapping(value = "/ordemDePedidos")
public class RecursoOrdemDePedido {
	
	@Autowired
	private ServicoOrdemDePedido servicoAux;

//responseEntity vai receber a classe OrdemDePedido
	@GetMapping
	public ResponseEntity<List<OrdemDePedido>> findAll(){
		List<OrdemDePedido> listServicoEncontrado = servicoAux.findAll(); 
		return ResponseEntity.ok().body(listServicoEncontrado); 
	}
	@GetMapping(value = "/{id}") // esse comando indica que vou aceitar um ID na requisicao da minha URL
	public ResponseEntity<OrdemDePedido> findById(@PathVariable Long id){
		OrdemDePedido wObjeto = servicoAux.findById(id);
		return ResponseEntity.ok().body(wObjeto);
	}
}