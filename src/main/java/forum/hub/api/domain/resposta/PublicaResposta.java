package forum.hub.api.domain.resposta;

import forum.hub.api.domain.ValidacaoExceptions;
import forum.hub.api.domain.topico.TopicoRepository;
import forum.hub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicaResposta {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    public DadosDetalhamentoResposta postarResposta (DadosCadastroResposta dados){
        if (!usuarioRepository.existsById(dados.idAutor())) {
            throw new ValidacaoExceptions("ID do usuario informado não existe");
        }

        if (!topicoRepository.existsById(dados.idTopico())) {
            throw new ValidacaoExceptions("Id do Topico informado não existe");
        }

        var usuario = usuarioRepository.getReferenceById(dados.idAutor());
        var topico = topicoRepository.getReferenceById(dados.idTopico());

        var resposta = new Resposta(dados, usuario, topico);
        respostaRepository.save(resposta);

        return new DadosDetalhamentoResposta(resposta);
    }
}
