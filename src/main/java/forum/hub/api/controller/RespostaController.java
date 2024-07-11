package forum.hub.api.controller;


import forum.hub.api.domain.resposta.DadosCadastroResposta;
import forum.hub.api.domain.resposta.PublicaResposta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private PublicaResposta publicaResposta;


    @PostMapping
    @Transactional
    public ResponseEntity publicaResposta(@RequestBody DadosCadastroResposta dadosResposta, UriComponentsBuilder uriComponentsBuilder) {
        var dto = publicaResposta.postarResposta(dadosResposta);
        var uri = uriComponentsBuilder.path("/resposta/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }


}
