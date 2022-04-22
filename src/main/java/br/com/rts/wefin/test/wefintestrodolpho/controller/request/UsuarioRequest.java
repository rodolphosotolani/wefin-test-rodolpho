package br.com.rts.wefin.test.wefintestrodolpho.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    @NotBlank
    @Length(max = 250)
    private String nome;

    @NotBlank
    @Length(max = 250)
    private String email;

    @NotBlank
    @Length(max = 50)
    private String password;

    @NotBlank
    @Length(max = 50)
    private String username;
}
