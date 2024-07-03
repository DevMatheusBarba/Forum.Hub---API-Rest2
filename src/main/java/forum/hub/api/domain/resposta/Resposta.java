package forum.hub.api.domain.resposta;

import forum.hub.api.domain.topico.Topico;
import forum.hub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Entity
@Table(name = "respostas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private LocalTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "idtopico", nullable = false)
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "idautor", nullable = false)
    private Usuario usuario;

}
