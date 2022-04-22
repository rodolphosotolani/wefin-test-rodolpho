package br.com.rts.wefin.test.wefintestrodolpho.controller.response;

import br.com.rts.wefin.test.wefintestrodolpho.enums.TipoIdentificadorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

    private Long id;

    private String nome;

    private String identificador;

    private TipoIdentificadorEnum tipoIdentificador;
}
