package br.com.rts.wefin.test.wefintestrodolpho.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    @NotBlank(message = "O campo nome é obrigatório!")
    private String name;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Min(value = 11, message = "O campo Identificador deve ter no minimo 11 dígitos!")
    @Max(value = 14, message = "O campo Identificador deve ter no máximo 14 dígitos!")
    private String identificador;

}
