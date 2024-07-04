package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.DadosListaCurso;
import forum.hub.api.domain.usuario.DadosListaUsuario;

import java.time.LocalDateTime;

public record DadosListaTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Situacao situacao,
        DadosListaUsuario usuario,
        DadosListaCurso curso

) {
    public DadosListaTopico(Topico t) {
    }
}
