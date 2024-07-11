package forum.hub.api.domain.resposta;

import forum.hub.api.domain.topico.DadosListaTopico;
import forum.hub.api.domain.usuario.cadastro.DadosListaUsuario;

import java.time.OffsetDateTime;

public record DadosDetalhamentoResposta(Long id, String mensagem, OffsetDateTime dataDeCriacao, DadosListaUsuario usuario, DadosListaTopico topico) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), new DadosListaUsuario(resposta.getUsuario()),new DadosListaTopico(resposta.getTopico()));
    }
}
