package forum.hub.api.controller;


import forum.hub.api.domain.topico.*;
import forum.hub.api.domain.usuario.DadosDetalhamentoUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
   private PublicaTopico publicar;

    @Autowired
    TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity publicar (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriComponentsBuilder){
        System.out.println(dados);


        var dto = publicar.postar(dados);

        var uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity detalhamento(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }


}
