package forum.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        Long idautor,
        @NotBlank
        Long idcurso
) {
}
