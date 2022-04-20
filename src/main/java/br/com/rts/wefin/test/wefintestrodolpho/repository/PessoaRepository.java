package br.com.rts.wefin.test.wefintestrodolpho.repository;

import br.com.rts.wefin.test.wefintestrodolpho.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
