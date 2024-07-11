package forum.hub.api.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResposta(
        @NotBlank
        String mensagem,
        @NotNull
        Long idTopico,
        @NotNull
        Long idAutor
) {
}