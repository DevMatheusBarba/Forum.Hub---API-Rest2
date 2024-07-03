package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.Curso;
import forum.hub.api.domain.resposta.Resposta;
import forum.hub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Situacao situacao, Usuario usuario, Curso curso, List<Resposta> respostas) {


    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),topico.getSituacao(), topico.getUsuario(),topico.getCurso(),topico.getRespostas());
    }
}
