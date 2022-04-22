 package br.com.rts.wefin.test.wefintestrodolpho.controller;

 import br.com.rts.wefin.test.wefintestrodolpho.controller.request.PessoaRequest;
 import br.com.rts.wefin.test.wefintestrodolpho.controller.response.PessoaResponse;
 import br.com.rts.wefin.test.wefintestrodolpho.entity.Pessoa;
 import br.com.rts.wefin.test.wefintestrodolpho.mapper.PessoaMapper;
 import br.com.rts.wefin.test.wefintestrodolpho.service.PessoaService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import javax.xml.bind.ValidationException;
 import java.util.List;
 import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> createPessoa(
            @RequestBody @Valid PessoaRequest request) {

        Pessoa pessoa = service.createPessoa(pessoaMapper.requestToEntity(request));

        return ResponseEntity.ok(pessoaMapper.entityToResponse(pessoa));
    }

    @PutMapping("/{idPessoa}")
    public PessoaResponse updatePessoa(
            @PathVariable Long idPessoa,
            @RequestBody @Valid PessoaRequest request) throws ValidationException {

        Pessoa pessoa = service.updatePessoa(idPessoa, pessoaMapper.requestToEntity(request));

        return pessoaMapper.entityToResponse(pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void deletePessoa(
            @PathVariable Long idPessoa) throws ValidationException {
        service.deletePessoa(idPessoa);
    }

    @GetMapping("/{idPessoa}")
//    @ApiOperation(value = "Busca uma Pessoa por id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Encontrado a pessoa", response = PessoaResponse.class),
//            @ApiResponse(code = 400, message = "Id fornecido é inválido!"),
//            @ApiResponse(code = 404, message = "Pessoa não encontrada!")
//    })
    public ResponseEntity<PessoaResponse> getPessoaById(@PathVariable Long idPessoa) {

        Optional<Pessoa> optionalPessoa = service.getPessoaById(idPessoa);

        if (optionalPessoa.isPresent())
            return ResponseEntity.ok(pessoaMapper.entityToResponse(optionalPessoa.get()));

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> getAllPessoa() {

        List<Pessoa> pessoaList = service.getAllPessoa();

        return ResponseEntity.ok(pessoaMapper.entityToResponse(pessoaList));
    }
}
