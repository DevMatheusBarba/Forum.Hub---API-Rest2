package forum.hub.api.controller;

import forum.hub.api.domain.usuario.cadastro.DadosCadastroUsuario;
import forum.hub.api.domain.usuario.cadastro.DadosDetalhamentoUsuario;
import forum.hub.api.domain.usuario.Usuario;
import forum.hub.api.domain.usuario.UsuarioRepository;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    @Transient
    public ResponseEntity cadastroUsuario (@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder){
        var senhaHash = encoder.encode(dados.senha());
        var usuario = new Usuario(dados);
        usuario.setSenha(senhaHash);
        repository.save(usuario);
        var uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

}
