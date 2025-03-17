package teste.recursos;
//CONTROLADOR REST

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.Servico.ServicoProduto;
import teste.entidade.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
@Autowired
	private ServicoProduto servicoAux;

//responseEntity vai receber a classe Produto
	@GetMapping // procura todos os produtos
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> listServicoEncontrado = servicoAux.findAll(); 
		return ResponseEntity.ok().body(listServicoEncontrado); 
	}
	@GetMapping(value = "/{id}") // esse comando indica que vou aceitar um ID na requisicao da minha URL
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto wObjeto = servicoAux.findById(id);
		return ResponseEntity.ok().body(wObjeto);
	}
}