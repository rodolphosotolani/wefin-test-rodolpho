package br.com.rts.wefin.test.wefintestrodolpho.controller.request;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;

import static br.com.rts.wefin.test.wefintestrodolpho.configurations.validation.ClientErrorResponse.PASSWORD_IS_EMPTY;
import static br.com.rts.wefin.test.wefintestrodolpho.configurations.validation.ClientErrorResponse.USERNAME_IS_EMPTY;

@Data
public class LoginRequest {

    @NotEmpty(message = USERNAME_IS_EMPTY)
    private String email;

    @NotEmpty(message = PASSWORD_IS_EMPTY)
    private String senha;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.getEmail(), this.getSenha());
    }

}
