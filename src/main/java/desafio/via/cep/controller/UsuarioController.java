package desafio.via.cep.controller;

import desafio.via.cep.model.Usuario;
import desafio.via.cep.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioServiceImplementation;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> findAllUsers() {
        return ResponseEntity.ok(usuarioServiceImplementation.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUserById(@PathVariable Long id) {
        Usuario usuario = usuarioServiceImplementation.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> persistUser(@RequestBody Usuario usuario) {
        usuarioServiceImplementation.inserir(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
        usuarioServiceImplementation.atualizar(usuario.getId(), usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioServiceImplementation.deletar(id);
        return ResponseEntity.ok().build();
    }
}
