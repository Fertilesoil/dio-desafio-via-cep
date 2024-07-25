package desafio.via.cep.service;

import desafio.via.cep.model.Usuario;

public interface UsuarioService {
    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
