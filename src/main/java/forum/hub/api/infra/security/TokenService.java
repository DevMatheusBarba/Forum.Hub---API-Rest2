package forum.hub.api.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import forum.hub.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        try {
            var algoritimo = Algorithm.HMAC256("1234567890");  //Criação do tipo do algoritimo, no caso o HMAC256
            return  JWT.create() //Criar o Token
                    .withIssuer("Forum Hub")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception); //
        }
    }

    private Instant dataExpiracao() {
        return Instant.now().plus(2, ChronoUnit.HOURS); //Logica para criar um tempo de duas horas de duração
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("Forum Hub") //Verificar também se os dado batem ná hora de descodificar
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }
}
