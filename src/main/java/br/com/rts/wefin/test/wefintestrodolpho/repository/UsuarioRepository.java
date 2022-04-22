package br.com.rts.wefin.test.wefintestrodolpho.repository;

import br.com.rts.wefin.test.wefintestrodolpho.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    @Query(" SELECT usu " +
            "FROM Usuario AS usu " +
            "WHERE (UPPER(usu.nome) LIKE ?1 OR ?1 IS NULL) ")
    Page<Usuario> findByNome(String formatterString, Pageable pageable);

    Optional<Usuario> findByEmail(String email);

    @Query(" SELECT usu " +
            "FROM Usuario AS usu " +
            "WHERE UPPER(usu.email) LIKE ?1 " +
            " AND UPPER(usu.username) NOT LIKE ?2 ")
    Optional<Usuario> findByEmailOutroUsername(String email, String username);
}
