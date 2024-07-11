package forum.hub.api.domain.curso;

import forum.hub.api.domain.topico.Topico;

public record DadosListaCurso(
        String nome,
        Categoria categoria
) {
    public DadosListaCurso(Curso curso) {
    this(curso.getNome(), curso.getCategoria());
    }

}
