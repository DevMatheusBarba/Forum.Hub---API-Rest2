package forum.hub.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import forum.hub.api.domain.curso.Curso;
import forum.hub.api.domain.resposta.Resposta;
import forum.hub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Entity(name = "topicos")
@Table(name = "topicos", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo","mensagem"})})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensagem;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "idautor", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;


    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;


    public Topico(DadosCadastroTopico dados, Usuario dadoUser, Curso dadoCurso) {
        this(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), Situacao.ABERTO, dadoUser,dadoCurso,null);
    }
};
