package forum.hub.api.domain.topico;

import forum.hub.api.domain.ValidacaoExceptions;
import forum.hub.api.domain.curso.Curso;
import forum.hub.api.domain.resposta.Resposta;
import forum.hub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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

    private OffsetDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;


    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    private boolean ativo;


    public Topico(DadosCadastroTopico dados, Usuario dadoUser, Curso dadoCurso) {
        this(null, dados.titulo(), dados.mensagem(), OffsetDateTime.now(), Situacao.ABERTO, dadoUser,dadoCurso,null, true);
    }

    public void atualizaDados(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.situacao() != null){
            this.situacao = dados.situacao();
        }
    }

    public void desativar (){
        if (this.situacao == Situacao.ABERTO){
            this.situacao = Situacao.FECHADO;
        }
        if (this.ativo == false){
            throw new ValidacaoExceptions("Topico já foi excluido");
        }
        this.ativo = false;
    }
};
