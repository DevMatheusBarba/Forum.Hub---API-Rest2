package forum.hub.api.controller;


import forum.hub.api.domain.topico.DadosCadastroTopico;
import forum.hub.api.domain.topico.DadosDetalhamentoTopico;
import forum.hub.api.domain.topico.Topico;
import forum.hub.api.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

//    @PostMapping
//    @Transactional
//    public ResponseEntity publicar (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriComponentsBuilder){
//
//        var dto = publicar.postar(dados);
//
//        repository.save(topico);
//
//        var uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
//    }


}
