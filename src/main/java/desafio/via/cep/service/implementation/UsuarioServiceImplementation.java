package desafio.via.cep.service.implementation;

import desafio.via.cep.model.Endereco;
import desafio.via.cep.model.Usuario;
import desafio.via.cep.repository.EnderecoRepository;
import desafio.via.cep.repository.UsuarioRepository;
import desafio.via.cep.service.UsuarioService;
import desafio.via.cep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioServiceImplementation implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
        salvarComCep(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioCadastrado = usuarioRepository.findById(id);
        if(usuarioCadastrado.isPresent())
            salvarComCep(usuario);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    private void salvarComCep(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
    }
}
