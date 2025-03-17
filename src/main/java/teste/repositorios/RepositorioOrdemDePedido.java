package teste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import teste.entidade.OrdemDePedido;

public interface RepositorioOrdemDePedido extends JpaRepository<OrdemDePedido, Long>{

}
