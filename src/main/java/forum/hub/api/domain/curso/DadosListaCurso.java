package forum.hub.api.domain.curso;

public record DadosListaCurso(
        String nome,
        Categoria categoria
) {
    public DadosListaCurso(Curso curso) {
    this(curso.getNome(), curso.getCategoria());
    }
}
