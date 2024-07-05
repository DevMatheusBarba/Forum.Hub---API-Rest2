package forum.hub.api.domain.topico;

import forum.hub.api.domain.resposta.Resposta;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        Situacao situacao,
        Resposta resposta

) {
}
