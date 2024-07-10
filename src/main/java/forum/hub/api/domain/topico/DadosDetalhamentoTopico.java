package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.DadosListaCurso;
import forum.hub.api.domain.resposta.Resposta;
import forum.hub.api.domain.usuario.DadosListaUsuario;

import java.time.OffsetDateTime;
import java.util.List;


public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, OffsetDateTime dataCriacao, Situacao situacao, DadosListaUsuario usuario, DadosListaCurso curso, List<Resposta> respostas, Boolean ativo) {


    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),topico.getSituacao(), new DadosListaUsuario(topico.getUsuario()),new DadosListaCurso(topico.getCurso()),topico.getRespostas(), topico.isAtivo());
    }

}
