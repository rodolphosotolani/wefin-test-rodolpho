package br.com.rts.wefin.test.wefintestrodolpho.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ValidationErrorResponse {

    private String campo;
    private String erro;

}
