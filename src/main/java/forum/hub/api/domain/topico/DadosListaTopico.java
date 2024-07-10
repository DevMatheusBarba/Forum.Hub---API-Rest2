package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.DadosListaCurso;
import forum.hub.api.domain.usuario.DadosListaUsuario;

import java.time.OffsetDateTime;

public record DadosListaTopico(
        Long id,
        String titulo,
        String mensagem,
        OffsetDateTime dataCriacao,
        Situacao situacao,
        DadosListaUsuario usuario,
        DadosListaCurso curso,
        Boolean ativo

) {
    public DadosListaTopico(Topico dados) {
        this(dados.getId(), dados.getTitulo(), dados.getMensagem(), dados.getDataCriacao(), dados.getSituacao(), new DadosListaUsuario(dados.getUsuario()), new DadosListaCurso(dados.getCurso()), dados.isAtivo());
    }
}
