package teste.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.entidade.Categoria;

@Repository // Nesse caso é opicional porque o JPA ja possui a dependencia pra injetar 
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
