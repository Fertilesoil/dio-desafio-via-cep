package desafio.via.cep.repository;

import desafio.via.cep.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
