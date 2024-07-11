package forum.hub.api.controller;


import forum.hub.api.domain.usuario.Usuario;
import forum.hub.api.domain.usuario.login.DadosAutenticacao;
import forum.hub.api.infra.security.DadosToken;
import forum.hub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autenticacao = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        System.out.println(tokenJWT);
        return ResponseEntity.ok(new DadosToken(tokenJWT));
    };

}
