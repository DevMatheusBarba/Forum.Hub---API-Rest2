package forum.hub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository< Topico, Long> {

    Page<Topico> findTop10ByAtivoTrueOrderByDataCriacao(Pageable paginacao);

    @Query(nativeQuery = true,value = "SELECT * FROM topicos WHERE titulo ILIKE %:busca% AND ativo = true ")
    Page<Topico> buscarPersonalizada(Pageable paginacao,String busca);
}
