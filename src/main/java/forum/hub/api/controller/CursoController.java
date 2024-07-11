package forum.hub.api.controller;


import forum.hub.api.domain.curso.Curso;
import forum.hub.api.domain.curso.CursoRepository;
import forum.hub.api.domain.curso.DadosCadastroCurso;
import forum.hub.api.domain.curso.DadosDetalhamentoCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transient
    public ResponseEntity cadastroCurso (@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriComponentsBuilder){
        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }
}
