package br.com.rts.wefin.test.wefintestrodolpho.service;

import br.com.rts.wefin.test.wefintestrodolpho.entity.Pessoa;
import br.com.rts.wefin.test.wefintestrodolpho.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa createPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa updatePessoa(Long idPessoa, Pessoa pessoa) throws ValidationException {
        if (repository.existsById(idPessoa)){
//            pessoa.setId(idPessoa);
            return repository.save(pessoa);
        }

        throw new ValidationException("Não foi possível encontrar a pessoa com este código!");
    }

    public void deletePessoa(Long idPessoa) throws ValidationException {

        if (repository.existsById(idPessoa)){
            repository.deleteById(idPessoa);
        }

        throw new ValidationException("Não foi possível encontrar a pessoa com este código!");
    }

    public List<Pessoa> getAllPessoa() {
        return repository.findAll();
    }

    public Optional<Pessoa> getPessoaById(Long idPessoa) {
        return repository.findById(idPessoa);
    }
}
