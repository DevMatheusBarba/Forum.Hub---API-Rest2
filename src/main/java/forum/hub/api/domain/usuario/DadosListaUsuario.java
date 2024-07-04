package forum.hub.api.domain.usuario;

public record DadosListaUsuario(
        String nome,
        String email
) {
    public DadosListaUsuario(Usuario usuario) {
    this(usuario.getNome(), usuario.getEmail());
    }
}
