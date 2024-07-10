package forum.hub.api.controller;


import forum.hub.api.domain.ValidacaoExceptions;
import forum.hub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
   private PublicaTopico publicar;

    @Autowired
    TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity publicar (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriComponentsBuilder){
        var dto = publicar.postar(dados);
        var uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListaTopico>> listaDeTopicos (@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){

        var page = repository.findTop10ByAtivoTrueOrderByDataCriacao(paginacao).map(t -> new DadosListaTopico(t));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/search={busca}")
    public ResponseEntity<Page<DadosListaTopico>> buscaPersonalizada (@PageableDefault(size = 10, sort = {"topicos.data_criacao"}) Pageable paginacao, @PathVariable String busca ){
        var buscaCorrigido = busca.replace('+',' ');
        var page = repository.buscarPersonalizada(paginacao,buscaCorrigido).map(t -> new DadosListaTopico(t));
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizaTopico(@RequestBody @Valid DadosAtualizacaoTopico dados){
        if (!repository.existsById(dados.id())){
            throw new ValidacaoExceptions("Topico informado não existe");
        }
        var topico = repository.getReferenceById(dados.id());
        topico.atualizaDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluiTopicos (@PathVariable Long id){
        if (!repository.existsById(id)){
            throw new ValidacaoExceptions("Topico informado não existe");
        }
        var topico = repository.getReferenceById(id);
        topico.desativar();
        return ResponseEntity.noContent().build();
    }


}
