package br.com.rts.wefin.test.wefintestrodolpho.controller.response;

import br.com.rts.wefin.test.wefintestrodolpho.enums.TipoIdentificadorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PessoaResponse {

    @ApiModelProperty(name = "Código da Pessoa")
    private Long id;

    private String nome;

    private String identificador;

    private TipoIdentificadorEnum tipoIdentificador;
}
