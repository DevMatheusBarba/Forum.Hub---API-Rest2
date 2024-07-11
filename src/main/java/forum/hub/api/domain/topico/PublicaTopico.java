package forum.hub.api.domain.topico;


import forum.hub.api.domain.ValidacaoExceptions;
import forum.hub.api.domain.curso.CursoRepository;
import forum.hub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicaTopico {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DadosDetalhamentoTopico postar(DadosCadastroTopico dados) {
        if (!cursoRepository.existsById(dados.idcurso())) {
            throw new ValidacaoExceptions("ID do curso informado não existe");
        }

        if (!usuarioRepository.existsById(dados.idautor())) {
            throw new ValidacaoExceptions("Id do autor informado não existe na tabela usuários");
        }

        var curso = cursoRepository.getReferenceById(dados.idcurso());
        var usuario = usuarioRepository.getReferenceById(dados.idautor());
        var topico = new Topico(dados, usuario, curso);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }


}


