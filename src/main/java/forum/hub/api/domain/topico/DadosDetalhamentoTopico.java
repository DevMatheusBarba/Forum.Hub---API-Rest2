package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.DadosListaCurso;
import forum.hub.api.domain.resposta.Resposta;
import forum.hub.api.domain.usuario.cadastro.DadosListaUsuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.util.List;


public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, OffsetDateTime dataCriacao, Situacao situacao, DadosListaUsuario usuario, DadosListaCurso curso, int respostas, Boolean ativo) {


    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getSituacao(),
                new DadosListaUsuario(topico.getUsuario()),
                new DadosListaCurso(topico.getCurso()),
                topico.getRespostas() != null ? topico.getRespostas().size() : 0,
                topico.isAtivo());
    }


}
