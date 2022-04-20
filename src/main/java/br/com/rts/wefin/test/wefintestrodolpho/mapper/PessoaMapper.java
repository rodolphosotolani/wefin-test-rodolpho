package br.com.rts.wefin.test.wefintestrodolpho.mapper;

import br.com.rts.wefin.test.wefintestrodolpho.controller.request.PessoaRequest;
import br.com.rts.wefin.test.wefintestrodolpho.controller.response.PessoaResponse;
import br.com.rts.wefin.test.wefintestrodolpho.entity.Pessoa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa requestToEntity(PessoaRequest request);

    PessoaResponse entityToResponse(Pessoa pessoa);

    List<PessoaResponse> entityToResponse(List<Pessoa> pessoaList);
}
