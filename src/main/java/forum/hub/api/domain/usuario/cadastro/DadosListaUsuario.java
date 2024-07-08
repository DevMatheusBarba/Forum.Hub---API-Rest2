package forum.hub.api.domain.usuario.cadastro;

import forum.hub.api.domain.usuario.Usuario;

public record DadosListaUsuario(
        String nome,
        String email
) {
    public DadosListaUsuario(Usuario usuario) {
    this(usuario.getNome(), usuario.getEmail());
    }
}
