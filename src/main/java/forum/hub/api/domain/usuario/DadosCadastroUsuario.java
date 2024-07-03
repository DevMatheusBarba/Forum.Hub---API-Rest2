package forum.hub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @Email @NotBlank
        String email,
        @NotBlank @Pattern(regexp = "\\d{8,70}")
        String senha
) {
}
