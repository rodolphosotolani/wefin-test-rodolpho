package br.com.rts.wefin.test.wefintestrodolpho.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServerErrorResponse {
    public static final String SOMETHING_WENT_WRONG = "somenthing.went.wrong";
    String message;
}
