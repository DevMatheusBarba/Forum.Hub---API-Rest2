package forum.hub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository< Topico, Long> {

    Page<Topico> findAll(Pageable paginacao);
}
